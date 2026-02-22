package org.dsa.examples.nc150.arrays;

import java.util.*;

class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 1
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        // 2
        int maxLen = 0;

        for (int i : set) {
            // 2.1 Find the start of the sequence
            int prev = i - 1;
            if (set.contains(prev)) {
                continue;
            }
            // 2.2 Count the length of the sequence
            int count = 1;
            int current = i;
            while (true) {
                current++;
                if (!set.contains(current)) {
                    break;
                }
                count++;
            }
            // 2.3 Update max length
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }
}