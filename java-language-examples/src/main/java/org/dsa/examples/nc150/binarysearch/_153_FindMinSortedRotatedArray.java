package org.dsa.examples.nc150.binarysearch;

class _153_FindMinSortedRotatedArray {
    public int findMin(int[] nums) {
      int l = 0;
      int r = nums.length -1;
      while(l <=r){
        int m = l + (r-l)/ 2;
        if(m > 0 && nums[m-1] > nums[m]){
            return nums[m];
        }
        // 3,4,5,6,7,1,2
        // left is sorted and mid is greater than right
        // so small is present in right side
        // and hence reduce to search space by updating left.
        if(nums[l] <= nums[m] && nums[m] > nums[r]){
            l = m + 1;
        }
        else{
            r = m -1;
        }
      }  
      return nums[l];
    }
}