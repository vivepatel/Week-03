package filereader.countfrequency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountFrequency {
    public static void main(String[] args) {
        String filename = "Sample.txt";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target string");
        String target = sc.next();
        int count=0;

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine())!=null){
                String[] arr = line.split(" ");
                for(int i=0;i<arr.length;i++){
                    if(arr[i].equals(target))count++;
                }
            }
            System.out.println("Total Count of "+target+" is "+count);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
