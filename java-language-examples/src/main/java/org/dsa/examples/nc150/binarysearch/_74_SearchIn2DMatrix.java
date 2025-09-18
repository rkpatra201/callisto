package org.dsa.examples.nc150.binarysearch;

public class _74_SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix[0].length * matrix.length -1;

        int col = matrix[0].length;
        while(start <= end){
            int m = start + (end-start) / 2;
            int i = m / col;
            int j = m % col;
            int mv = matrix[i][j];
            if(mv == target){
                return true;
            }
            else if(mv < target){
                start = m + 1;
            }
            else{
                end = m - 1;
            }
        }
        return false;
    }
}
