package org.dsa.examples.dp.str.str;

public class _4LongestCommonSubstrLength {

    public int solution(String p1, String p2) {

        int commonLength = 0;
        commonLength = solution(p1, p2, p1.length(), p2.length(), 0);
        return commonLength;
    }

    private int solution(String p1, String p2, int index1, int index2, int maxLength) {
        if (index1 == p1.length() || index2 == p2.length()) {
            return maxLength;
        }
        // when match occurs reduce each string and increment maxLength by 1
        if (p1.charAt(index1) == p2.charAt(index2)) {
            maxLength = solution(p1, p2, index1 + 1, index2 + 1, maxLength + 1);
        }

        // as no match occurred, next recursive calls will start with maxLength = 0

        // considering first string but reducing second string
        int inclusionLength = solution(p1, p2, index1, index2 + 1, 0);
        // considering first string but reducing second string
        int exclusionLength = solution(p1, p2, index1 + 1, index2, 0);

        // update maxLength by selecting max out of inclusionLength and exclusionLength
        maxLength = Math.max(Math.max(inclusionLength, exclusionLength), maxLength);
        return maxLength;

    }
}
