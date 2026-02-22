package org.dsa.examples.lc.sw;

import java.util.ArrayList;
import java.util.List;

public class _239MaxInSwOfK {

  public static void main(String[] args) {
    List<Integer> list = List.of(1, 3, -1, -3, 5, 3, 6, 7);
    int k = 3;
  //  list = List.of(1, -1);
   // k = 1;
    new _239MaxInSwOfK().maxSlidingWindow(list.stream().mapToInt(Integer::intValue).toArray(),
        k);
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int firstMax = nums[0];
    int count = 1;
    int idx = 0;
    List<Integer> list = new ArrayList<>();

    int maxSeenAt = 0;
    while (count <= k && idx < nums.length) {
      firstMax = Math.max(firstMax, nums[idx]);
      if (firstMax == nums[idx]) {
        maxSeenAt = idx;
      }
      count++;
      idx++;

    }

    System.out.println(firstMax);
    list.add(firstMax);

    int i = idx;
    int windowStart = idx - k;
    idx = windowStart;
    int maxInWindow = firstMax;
    int prevMax = maxInWindow;
    while (i < nums.length) {
      int numIn = nums[i];
      int numOut = nums[idx];
      if (maxSeenAt < idx + 1) {
        maxInWindow = Integer.MIN_VALUE;
      }
      int possibleMaxInWindow = Math.max(maxInWindow, numIn);
      if (numOut == maxInWindow) {
        maxInWindow = possibleMaxInWindow;
      } else {
        maxInWindow = Math.max(maxInWindow, possibleMaxInWindow);
      }
      if (prevMax != maxInWindow) {
        maxSeenAt = i;
        prevMax = maxInWindow;
      }
      idx++;
      i++;
      list.add(maxInWindow);
    }
    System.out.println(list);
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
