package org.dsa.examples.nc150.binarysearch;

class _33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
      int start = 0;
      int end = nums.length -1;
      while(start <= end){
        int m = start + (end-start) / 2;
        int mv = nums[m];
        if(target == mv){
            return m;
        }
        if(nums[start]<= mv){ // left is sorted
           if(nums[start]<= target && target <= mv){ 
            // check target lies between start and mid
             end = m -1;
           }
           else{
            start = m +1;
           }
        }
        else{ // right sorted
          if(mv <= target && target <= nums[end]){
            // check target lies between mid and end
            start = m + 1;
          }
          else{
            end = m -1;
          } 
        }
      }  

      return -1;
    }
}