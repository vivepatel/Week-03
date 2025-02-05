package stringbuffer.concatenatestrings;

import java.util.Scanner;

public class ConcatenateStrings {

    public static String Concat(String[] arr){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[] arr = new String[size];

        for(int i=0;i<size;i++){
            arr[i] = sc.next();
        }

        System.out.println(Concat(arr));
    }
}
