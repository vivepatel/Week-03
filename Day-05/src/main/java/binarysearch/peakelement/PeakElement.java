package binarysearch.peakelement;
public class PeakElement{
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n-1;
        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if( nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }else if( nums[mid]>nums[mid-1]){
                start=mid+1;
            }else{
                end=mid-1;
            }
            mid=start+(end-start)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int []arr= {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));

    }


}


