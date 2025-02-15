package org.dsa.examples.arrays;


import utils.ArrayUtils;

public class ArrayPartitionSmallAndLarge {
    public void solution(int[] nums, int pivotValue){
        int i = 0;
        int j = nums.length - 1;


        while (i <=j) {

            if(nums[i] < pivotValue){
                i++;
            }
            else if(nums[j] > pivotValue){
                j--;
            }
            else{
                ArrayUtils.swap(nums, i, j);
                i++;
                j--;
            }
            
        }
    }
}
