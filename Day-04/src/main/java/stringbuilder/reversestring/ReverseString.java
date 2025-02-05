package stringbuilder.reversestring;

import java.util.Scanner;

public class ReverseString {

    public static String Reverse(StringBuilder sb){
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        s = Reverse(sb);
        System.out.println("Now String is "+s);
    }
}
