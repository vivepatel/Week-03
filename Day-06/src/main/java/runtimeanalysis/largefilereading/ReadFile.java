
package runtimeanalysis.largefilereading;

import java.io.*;

import static java.lang.System.nanoTime;

public class ReadFile {

    static void readUsingFileReader(String filename){
        try (FileReader fileReader = new FileReader(filename)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                // Reading file, nothing to process here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readUsingInputStreamReader(String filename){
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename))) {
            int data;
            while ((data = inputStreamReader.read()) != -1) {
                // Reading file, nothing to process here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        long starttime = nanoTime();
        readUsingFileReader("1 MB File");
        System.out.println("FileReader takes "+(nanoTime()-starttime)/1000000+" ms to read 1 MB File");

        starttime = nanoTime();
        readUsingInputStreamReader("1 MB File");
        System.out.println("InputStreamReader takes "+(nanoTime()-starttime)/1000000+" ms to read 1 MB File");


        starttime = nanoTime();
        readUsingFileReader("100 MB File");
        System.out.println("\nFileReader takes "+(nanoTime()-starttime)/1000000+" ms to read 100 MB File");

        starttime = nanoTime();
        readUsingInputStreamReader("100 MB File");
        System.out.println("InputStreamReader takes "+(nanoTime()-starttime)/1000000+" ms to read 100 MB File");


        starttime = nanoTime();
        readUsingFileReader("500 MB File");
        System.out.println("\nFileReader takes "+(nanoTime()-starttime)/1000000+" ms to read 500 MB File");

        starttime = nanoTime();
        readUsingInputStreamReader("500 MB File");
        System.out.println("InputStreamReader takes "+(nanoTime()-starttime)/1000000+" ms to read 500 MB File");
    }
}
