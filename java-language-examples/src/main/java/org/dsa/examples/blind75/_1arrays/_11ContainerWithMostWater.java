package org.dsa.examples.blind75._1arrays;

// https://leetcode.com/problems/container-with-most-water/submissions/1584685368/
public class _11ContainerWithMostWater {
  public int maxArea(int[] height) {

    int l = 0;
    int r = height.length - 1;

    int max = 0;
    while (l < r) {
      int lv = height[l];
      int rv = height[r];

      int h = Math.min(lv, rv);
      int len = Math.abs(l - r);
      int area = h * len;
      max = Math.max(area, max);

      if (lv < rv) {
        l++;
      } else {
        r--;
      }
    }

    return max;
  }
}
