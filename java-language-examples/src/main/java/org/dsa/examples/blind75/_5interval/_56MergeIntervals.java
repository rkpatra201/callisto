package org.dsa.examples.blind75._5interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _56MergeIntervals {
  public int[][] merge(int[]... intervals) {

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int[] interval : intervals) {
      pq.add(interval);
    }

    int[] prev = pq.poll();
    List<int[]> list = new ArrayList<>();
    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      boolean overlap = prev[0] < current[0]
          && current[0] < prev[1];
      if (!overlap) { // [1,2] [2,4] not overlap
        //  System.out.println(Arrays.toString(prev));
        list.add(prev);
        prev = current;
        continue;
      }
      // otherwise overlap happens below

      // 1. stays within previous interval
      // starts from same value
      // starts in between
      if (current[1] < prev[1]) {
        // say prev = [1,10]
        // current = [1,2] so we consider [1,10]
        // or current = [2,8] so we consider
        continue;
      }
      // 2. but goes out of prev interval, so expand previous interval
      prev[1] = current[1];
      // prev: [1,4]
      // current: [1,8]
      // or current: [2,10]
    }

    System.out.println(Arrays.toString(prev));
    list.add(prev);
    int[][] result = list.toArray(new int[0][]);
    // System.out.println(Arrays.deepToString(result));

    return result;
  }

  public static void main(String[] args) {
    int[][] intervals = new int[][]{
        {1, 3},
        {8, 10},
        {2, 6},
        {15, 18}
    };


  }


}
