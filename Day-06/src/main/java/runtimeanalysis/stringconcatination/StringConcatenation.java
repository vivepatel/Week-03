package runtimeanalysis.stringconcatenation;

import static java.lang.System.nanoTime;

public class StringConcatenation {
    public static void main(String[] args) {
        String s = "";
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();

        long starttime = nanoTime();
        for(int i=0;i<1000;i++){
            s += "a";
        }
        System.out.println("String contenation takes "+(nanoTime()-starttime)+" for 1000 concatenations");

        starttime = nanoTime();
        for(int i=0;i<1000;i++){
            sb.append("a");
        }
        System.out.println("StringBuilder contenation takes "+(nanoTime()-starttime)+" for 1000 concatenations");

        starttime = nanoTime();
        for(int i=0;i<1000;i++){
            sbf.append("a");
        }
        System.out.println("StringBuffer contenation takes "+(nanoTime()-starttime)+" for 1000 concatenations");


        starttime = nanoTime();
        for(int i=0;i<10000;i++){
            s += "a";
        }


        s = "";
        sb = new StringBuilder();
        sbf = new StringBuffer();
        System.out.println("\nString contenation takes "+(nanoTime()-starttime)+" for 10000 concatenations");

        starttime = nanoTime();
        for(int i=0;i<10000;i++){
            sb.append("a");
        }
        System.out.println("StringBuilder contenation takes "+(nanoTime()-starttime)+" for 10000 concatenations");

        starttime = nanoTime();
        for(int i=0;i<10000;i++){
            sbf.append("a");
        }
        System.out.println("StringBuffer contenation takes "+(nanoTime()-starttime)+" for 10000 concatenations");


        s = "";
        sb = new StringBuilder();
        sbf = new StringBuffer();
        starttime = nanoTime();
//        for(int i=0;i<1000000;i++){
//            s += "a";
//        }
//        System.out.println("\nString contenation takes "+(nanoTime()-starttime)+" for 1000000 concatenations");
        System.out.println("\nString contenation takes alot of time for 1000000 concatenations");

        starttime = nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append("a");
        }
        System.out.println("StringBuilder contenation takes "+(nanoTime()-starttime)+" for 1000000 concatenations");

        starttime = nanoTime();
        for(int i=0;i<1000000;i++){
            sbf.append("a");
        }
        System.out.println("StringBuffer contenation takes "+(nanoTime()-starttime)+" for 1000000 concatenations");
    }
}
