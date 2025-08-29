package org.dsa.examples.blind75._5interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _57InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    return merge(intervals, newInterval);
  }

  public int[][] merge(int[][] intervals, int[] newInterval) {

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int[] interval : intervals) {
      pq.add(interval);
    }
    pq.add(newInterval);

    int[] prev = pq.poll();
    List<int[]> list = new ArrayList<>();
    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      boolean overlap = current[0] >= prev[0] && current[0] <= prev[1];
      if (!overlap) {
        //  System.out.println(Arrays.toString(prev));
        list.add(prev);
        prev = current;
        continue;
      }
      if (current[1] < prev[1]) {
        continue;
      }
      prev[1] = current[1];
    }

    System.out.println(Arrays.toString(prev));
    list.add(prev);
    int[][] result = list.toArray(new int[0][]);
    // System.out.println(Arrays.deepToString(result));

    return result;
  }
}
