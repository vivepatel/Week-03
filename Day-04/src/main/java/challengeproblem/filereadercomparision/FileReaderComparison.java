package challengeproblem.filereadercomparision;

import java.io.*;

public class FileReaderComparison {
    public static void main(String[] args) {
        String filePath = "LargeFile.txt";

        long fileReaderTime = countWordsUsingFileReader(filePath);
        long inputStreamReaderTime = countWordsUsingInputStreamReader(filePath);

        System.out.println("\nFileReader Time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
    }


    public static long countWordsUsingFileReader(String filePath) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try{

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(" ");
                wordCount+=arr.length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("Words counted using FileReader: " + wordCount);
        return (endTime - startTime);
    }


    public static long countWordsUsingInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try{

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(" ");
                wordCount+=arr.length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("Words counted using InputStreamReader: " + wordCount);
        return (endTime - startTime);
    }
}
