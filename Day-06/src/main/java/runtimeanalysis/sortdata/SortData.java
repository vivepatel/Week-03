package runtimeanalysis.sortdata;

import java.util.ArrayList;
import static java.lang.System.nanoTime;

public class SortData {

    static int[] generateArray(int size){
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = (int) (Math.random()*size);
        }
        return arr;
    }

    static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            boolean flag = false;
            for(int j=1;j< arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    flag = true;
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(!flag)break;
        }
    }

    static void mergeSort(int[] arr,int s,int e){
        if(s>=e)return ;
        int mid = (s+e)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }

    static void merge(int[] arr,int s,int mid,int e){
        ArrayList<Integer> arrlist= new ArrayList<>();
        int idx1 = s,idx2 = mid+1;
        while(idx1<=mid&&idx2<=e){
            if(arr[idx1]<=arr[idx2]){
                arrlist.add(arr[idx1++]);
            }
            else{
                arrlist.add(arr[idx2++]);
            }
        }
        while(idx1<=mid){
            arrlist.add(arr[idx1++]);
        }
        while(idx2<=e){
            arrlist.add(arr[idx2++]);
        }
        for(int i=s;i<=e;i++){
            arr[i] = arrlist.get(i-s);
        }
    }

    static void quickSort(int[] arr,int low, int high){
        if(low<high){
            int pratition = partition(arr,low,high);
            quickSort(arr,low,pratition-1);
            quickSort(arr,pratition+1,high);
        }
    }

    static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i = low,j = high;
        while(i<j){
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

    static void display(int[] arr){
        for(int i:arr){
            System.out.print(i+", ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        long startTime = nanoTime();
        int[] dataset1 = generateArray(1000);
        bubbleSort(dataset1);
        System.out.println("Time taken by Bubble Sort for size of 1000 is "+(nanoTime()-startTime)+" ns");

        dataset1 = generateArray(1000);
        startTime=nanoTime();
        mergeSort(dataset1,0,999);
        System.out.println("Time taken by Merge Sort for size of 1000 is "+(nanoTime()-startTime)+" ns");

        dataset1 = generateArray(1000);
        startTime=nanoTime();
        quickSort(dataset1,0,999);
        System.out.println("Time taken by Quick Sort for size of 1000 is "+(nanoTime()-startTime)+" ns");


        int[] dataset2 = generateArray(10000);

        startTime = nanoTime();
        bubbleSort(dataset2);
        System.out.println("\nTime taken by Bubble Sort for size of 10000 is "+(nanoTime()-startTime)+" ns");

        dataset2 = generateArray(10000);
        startTime=nanoTime();
        mergeSort(dataset2,0,9999);
        System.out.println("Time taken by Merge Sort for size of 10000 is "+(nanoTime()-startTime)+" ns");

        dataset2 = generateArray(10000);
        startTime=nanoTime();
        quickSort(dataset2,0,9999);
        System.out.println("Time taken by Quick Sort for size of 10000 is "+(nanoTime()-startTime)+" ns");


        int[] dataset3 = generateArray(1000000);

        startTime = nanoTime();
        bubbleSort(dataset3);//comment it before running else it will take long time to get executed
//        System.out.println("\nTime taken by Bubble Sort for size of 1000000 is "+(nanoTime()-startTime)+" ns");
        System.out.println("Bubble sort Takes a lot of time");

        dataset3 = generateArray(1000000);
        startTime=nanoTime();
        mergeSort(dataset3,0,999999);
        System.out.println("Time taken by Merge Sort for size of 1000000 is "+(nanoTime()-startTime)+" ns");

        dataset3 = generateArray(1000000);
        startTime=nanoTime();
        quickSort(dataset3,0,999999);
        System.out.println("Time taken by Quick Sort for size of 1000000 is "+(nanoTime()-startTime)+" ns");
    }
}
