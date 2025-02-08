package runtimeanalysis.compareds;

import java.util.HashSet;
import java.util.TreeSet;

import static java.lang.System.nanoTime;

public class CompareDS {

    static int[] generateArray(int size){
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = (int) (Math.random()*size);
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] dataset1 = generateArray(1000000);

        HashSet<Integer> hs = new HashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();

        for(int i=0;i<1000;i++){
            hs.add(dataset1[i]);
            ts.add(dataset1[i]);
        }

        int target = dataset1[dataset1.length-1];

        long starttime = nanoTime();
        for(int i=0;i< dataset1.length;i++)if(dataset1[i]==target)break;

        System.out.println("Searching of last element of array in Array takes "+(nanoTime()-starttime));

        starttime=nanoTime();
        hs.contains(target);
        System.out.println("Searching of last element of array in HashSet takes "+(nanoTime()-starttime));

        starttime=nanoTime();
        ts.contains(target);
        System.out.println("Searching of last element of array in TreeSet takes "+(nanoTime()-starttime));


        target = -1;


        starttime = nanoTime();
        for(int i=0;i< dataset1.length;i++)if(dataset1[i]==target)break;

        System.out.println("\nSearching of element which is not present in Array takes "+(nanoTime()-starttime));

        starttime=nanoTime();
        hs.contains(target);
        System.out.println("Searching of element which is not present in HashSet takes "+(nanoTime()-starttime));

        starttime=nanoTime();
        ts.contains(target);
        System.out.println("Searching of element which is not present in TreeSet takes "+(nanoTime()-starttime));

    }
}
