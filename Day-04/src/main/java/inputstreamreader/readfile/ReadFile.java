package inputstreamreader.readfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
    public static void main(String[] args) {
        String filename = "Sample.txt";

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
