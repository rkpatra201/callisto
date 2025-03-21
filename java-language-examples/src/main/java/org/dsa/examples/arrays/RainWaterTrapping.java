package org.dsa.examples.arrays;

// https://leetcode.com/problems/trapping-rain-water/submissions/1564385703/

public class RainWaterTrapping {
  public int solution(int[] height) {
    int left = 0;
    int right = height.length - 1;

    int maxLeft = height[left];
    int maxRight = height[right];
    int total = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        int current = height[left];
        if (current > maxLeft) {
          maxLeft = current;
        } else {
          total = total + (maxLeft - current);
        }
        left++;
      } else {
        int current = height[right];
        if (current > maxRight) {
          maxRight = current;
        } else {
          total = total + (maxRight - current);
        }
        right--;
      }
    }

    return total;

  }
}
