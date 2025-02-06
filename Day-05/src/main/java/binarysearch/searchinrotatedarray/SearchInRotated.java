package binarysearch.searchinrotatedarray;
public class SearchInRotated {
    public static  int findrotatedindex(int []arr){
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        while (start < end) {
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else if (arr[mid] < arr[end]) {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};
        int ans = findrotatedindex(arr);
        System.out.println("Rotated index: " + ans);
    }


}
