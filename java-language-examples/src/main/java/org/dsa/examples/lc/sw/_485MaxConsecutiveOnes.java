package org.dsa.examples.lc.sw;

// https://leetcode.com/problems/max-consecutive-ones/submissions/1598818254/
public class _485MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0;

    int windowCount = 0;
    for(int i:nums){
      if(i == 0){
        maxCount = Math.max(windowCount, maxCount);
        windowCount=0;
        continue;
      }
      windowCount++;
    }
    maxCount = Math.max(windowCount, maxCount);
    return maxCount;
  }
}
