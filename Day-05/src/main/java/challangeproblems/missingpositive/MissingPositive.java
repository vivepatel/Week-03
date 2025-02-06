package challengeproblems.missingpositive;
import java.util.Arrays;

public class MissingPositive {
    public  static  int find(int []arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] and arr[arr[i] - 1]
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }


        System.out.println();
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return -1;
    }
    public  static int binarysearch(int []nums,int start,int end,int target){
        int mid=start+(end-start)/2;
        while(start<=end){
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]>target) {
                end=mid-1;
            }else{
                start=mid+1;
            }
            mid=start+(end-start)/2;
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};

        int missingpositive=find(nums);
        Arrays.sort(nums);
        int target=4;
        int indexoftarget=binarysearch(nums,0,nums.length-1,target);

        System.out.println("First missing positive number: "+missingpositive);
        System.out.println("Index of target: "+indexoftarget);
    }



}
