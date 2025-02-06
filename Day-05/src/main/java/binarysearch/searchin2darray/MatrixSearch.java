package binarysearch.searchin2darray;

class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        int totalelements=rows*columns;
        int start=0;
        int end=totalelements-1;
        int mid=start+(end-start)/2;
        while(start<=end){
            int row=mid/columns;
            int col=mid%columns;
            if(matrix[row][col]==target)return true;
            else if(matrix[row][col]>target)end=mid-1;
            else start=mid+1;
            mid=start+(end-start)/2;

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 16;

        System.out.println(searchMatrix(matrix, target));
    }
}
