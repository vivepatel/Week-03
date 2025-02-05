package stringbuilder.removeduplicates;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {


    public static String removeDuplicates(StringBuilder sb) {
        HashSet<Character> set = new HashSet<>();
        String ans="";

        for(int i=0;i<sb.length();i++){
            if(!set.contains(sb.charAt(i))){
                ans = ans+sb.charAt(i);
            }
            set.add(sb.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        s = removeDuplicates(sb);
        System.out.println("Now String is "+s);
    }
}
