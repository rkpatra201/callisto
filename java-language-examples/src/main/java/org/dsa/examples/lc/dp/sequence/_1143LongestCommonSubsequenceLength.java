package org.dsa.examples.lc.dp.sequence;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-common-subsequence/submissions/1569919554/
public class _1143LongestCommonSubsequenceLength {
    public int longestCommonSubsequence(String text1, String text2) {
        return solution(text1, text2);
    }

    public int solution(String p1, String p2) {

        int commonLength = 0;
        commonLength = solution(p1, p2, 0, 0);
        return commonLength;
    }

    private String getKey(int index1, int index2) {
        return index1 + ":" + index2;
    }

    private Map<String, Integer> memo = new HashMap<>();

    private int solution(String p1, String p2, int index1, int index2) {

        String key = getKey(index1, index2);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index1 == p1.length() || index2 == p2.length()) {
            return 0;
        }

        // when match occurs reduce each string and increment maxLength by 1
        if (p1.charAt(index1) == p2.charAt(index2)) {
            return solution(p1, p2, index1 + 1, index2 + 1) + 1;
        }
        // as no match occurred, next recursive calls will start with maxLength = 0

        // considering first string but reducing second string
        int inclusionLength = solution(p1, p2, index1, index2 + 1);
        // considering first string but reducing second string
        int exclusionLength = solution(p1, p2, index1 + 1, index2);

        int result = Math.max(inclusionLength, exclusionLength);
        memo.put(key, result);
        return result;

    }
}
