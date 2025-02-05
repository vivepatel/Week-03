package inputstreamreader.writefile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) {
        String filename = "input.txt";

        Scanner sc = new Scanner(System.in);

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            FileWriter fw = new FileWriter(filename);

            String line;

            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            while(true){
                line = sc.nextLine();

                if ("exit".equals(line)) {
                    break;
                }

                fw.write(line + "\n");
            }

            br.close();
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
