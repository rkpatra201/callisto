package org.dsa.examples.blind75._4graph;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/submissions/1609634274/?envType=problem-list-v2&envId=oizxjoit
public class _128LongestConsecutiveSequence_SetSoln {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }

    int maxLen = 0;

    for (int i : set) { // iterate on set as it is unique now. iterating on nums array gives TLE due to duplicate element
      int prev = i - 1;
      if (set.contains(prev)) {
        continue;
      }
      int count = 1;
      int current = i;
      while (true) {
        current++;
        if (!set.contains(current)) {
          break;
        }
        count++;
      }

      maxLen = Math.max(maxLen, count);
    }

    return maxLen;
  }
}
