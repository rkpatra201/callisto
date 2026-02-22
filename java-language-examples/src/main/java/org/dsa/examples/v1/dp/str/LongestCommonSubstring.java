package org.dsa.examples.v1.dp.str;

public class LongestCommonSubstring {

    public int solution(String p1, String p2) {

        int commonLength = 0;
        commonLength = solution(p1, p2, p1.length(), p2.length(), 0);
        return commonLength;
    }

    private int solution(String p1, String p2, int len1, int len2, int maxLength) {
        if (len1 == 0 || len2 == 0) {
            return maxLength;
        }
        // when match occurs reduce each string and increment maxLength by 1
        if (p1.charAt(len1 - 1) == p2.charAt(len2 - 1)) {
            maxLength = solution(p1, p2, len1 - 1, len2 - 1, maxLength + 1);
        }
        // as no match occurred, next recursive calls will start with maxLength = 0

        // considering first string but reducing second string
        int inclusionLength = solution(p1, p2, len1, len2 - 1, 0);
        // considering first string but reducing second string
        int exclusionLength = solution(p1, p2, len1 - 1, len2, 0);

        int result = Math.max(inclusionLength, exclusionLength);
        maxLength = Math.max(result, maxLength);
        return maxLength;

    }
}
