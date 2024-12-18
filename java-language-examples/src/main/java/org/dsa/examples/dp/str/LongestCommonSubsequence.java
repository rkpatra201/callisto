package org.dsa.examples.dp.str;

public class LongestCommonSubsequence {

    public int solution(String p1, String p2) {

        int commonLength = 0;
        commonLength = solution(p1, p2, p1.length(), p2.length());
        return commonLength;
    }

    private int solution(String p1, String p2, int len1, int len2) {

        if (len1 == 0 || len2 == 0) {
            return 0;
        }

        // when match occurs reduce each string and increment maxLength by 1
        if (p1.charAt(len1 - 1) == p2.charAt(len2 - 1)) {
            return solution(p1, p2, len1 - 1, len2 - 1) + 1;
        }
        // as no match occurred, next recursive calls will start with maxLength = 0

        // considering first string but reducing second string
        int inclusionLength = solution(p1, p2, len1, len2 - 1);
        // considering first string but reducing second string
        int exclusionLength = solution(p1, p2, len1 - 1, len2);

        int result = Math.max(inclusionLength, exclusionLength);

        return result;

    }
}
