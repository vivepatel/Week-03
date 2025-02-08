package runtimeanalysis.searchtarget;

import static java.lang.System.nanoTime;

public class SearchTarget {

    static int[] generateArray(int size){
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = (int) (Math.random()*size);
        }
        return arr;
    }

    static void linearSearch(int[] arr, int target){
        for (int i : arr) {
            if (i == target) {
                return;
            }
        }
    }

    static void binarySearch(int[] arr, int target){
        int mid,s=0,e=arr.length-1;
        while(s<=e){
            mid = s+(e-s)/2;
            if(arr[mid]==target)return;
            else if(arr[mid]<target)s = mid+1;
            else e = mid-1;
        }
    }

    public static void main(String[] args) {
        int[] dataset1 = generateArray(1000);

        long starttime = nanoTime();

        int target = dataset1[(int) (Math.random() * 1000)];
        linearSearch(dataset1,target);
        System.out.println("Time taken by linear search for size of 1000 is "+(nanoTime()-starttime)+" ns");
        starttime=nanoTime();
        binarySearch(dataset1,target);
        System.out.println("Time taken by binary search for size of 1000 is "+(nanoTime()-starttime)+" ns");


        int[] dataset2 = generateArray(10000);

        target = dataset2[(int) (Math.random() * 10000)];
        linearSearch(dataset2,target);
        System.out.println("\nTime taken by linear search for size of 10000 is "+(nanoTime()-starttime)+" ns");
        starttime=nanoTime();
        binarySearch(dataset2,target);
        System.out.println("Time taken by binary search for size of 10000 is "+(nanoTime()-starttime)+" ns");


        int[] dataset3 = generateArray(10000);

        target = dataset3[(int) (Math.random() * 10000)];
        linearSearch(dataset3,target);
        System.out.println("\nTime taken by linear search for size of 1000000 is "+(nanoTime()-starttime)+" ns");
        starttime=nanoTime();
        binarySearch(dataset3,target);
        System.out.println("Time taken by binary search for size of 1000000 is "+(nanoTime()-starttime)+" ns");


    }
}
