package org.dsa.examples.blind75.w1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/submissions/1581458370/
public class _2ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    boolean flag = false;
//    Arrays.sort(nums);
    Set<Integer> set = new HashSet<>();
    for(int i=0;i<nums.length;i++){
      if(!set.add(nums[i])){
        return true;
      }
    }
    return flag;
  }
}
