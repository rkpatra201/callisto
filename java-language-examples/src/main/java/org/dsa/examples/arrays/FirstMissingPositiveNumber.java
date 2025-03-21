package org.dsa.examples.arrays;

// https://www.notion.so/First-Missing-Positive-Number-1bc85d61746d80a8a53dde6bb4f6cec2
public class FirstMissingPositiveNumber {


  // pigeonhole inplace
  // https://www.youtube.com/watch?v=qLjmipfCceo

  // https://leetcode.com/problems/first-missing-positive/submissions/1574242755/


  public int solution(int[] nums){
    return new FirstMissingPositiveNumber().firstMissingPositive(nums);
  }


  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for(int i = 0; i < nums.length;i++){
      int v = nums[i];
      if(v > n || v <= 0){
        nums[i] = n + 1;
      }
    }

    // System.out.println(Arrays.toString(nums));
    for(int i = 0; i< nums.length;i++){
      //   System.out.println(Arrays.toString(nums));
      int v = Math.abs(nums[i]) ;
      if(v == n+1){
        continue;
      }
      int index = v - 1;
      //  System.out.println(v+":"+index);
      if(nums[index]>0){
        nums[index] = -1 * nums[index];
      }
    }

    for(int i=0; i < nums.length;i++){
      int v = nums[i];
      if(v > 0){
        return i + 1;
      }
    }

    return n+1;
  }
}
