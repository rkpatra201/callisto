package org.dsa.examples.v1.arrays;

// https://leetcode.com/problems/container-with-most-water/submissions/1564393118/
public class ContainerWithMostWater {


  public int solution(int[] height) {
    int left = 0;
    int right = height.length - 1;

    // formulae: min(leftValue,rightValue) * diff of index(right-left)

    int maxWater = 0;
    while (left < right) {
      if (height[left] < height[right]) {

        int leftValue = height[left];
        int rightValue = height[right];

        int minHeight = Math.min(leftValue, rightValue);
        int currentMax = minHeight * (right - left);
        maxWater = Math.max(maxWater,currentMax);

        left++;
      } else {

        int leftValue = height[left];
        int rightValue = height[right];

        int minHeight = Math.min(leftValue, rightValue);
        int currentMax = minHeight * (right - left);
        maxWater = Math.max(maxWater,currentMax);

        right--;
      }
    }

    return maxWater;
  }
}
