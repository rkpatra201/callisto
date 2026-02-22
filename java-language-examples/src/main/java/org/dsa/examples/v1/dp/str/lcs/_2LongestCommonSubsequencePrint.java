package org.dsa.examples.v1.dp.str.lcs;

import org.dsa.examples.v1.dp.sum.AppUtils;

public class _2LongestCommonSubsequencePrint {

    public String solution(String p1, String p2) {

        String commonSubSequence = "";
        commonSubSequence = solution(p1, p2, 0, 0);
        return commonSubSequence;
    }

    private String solution(String p1, String p2, int index1, int index2) {

        if (index1 == p1.length()  || index2 == p2.length()) {
            return "";
        }

        // when match occurs move forward in both the string
        if (p1.charAt(index1) == p2.charAt(index2)) {
            return p1.charAt(index1) +  solution(p1, p2, index1 + 1, index2 + 1) ;
        }
        // as no match occurred, next recursive calls will start with maxLength = 0

        // considering first string but reducing second string
        String inclusionSubsequence = solution(p1, p2, index1, index2 + 1);
        // considering first string but reducing second string
        String exclusionSubSequence = solution(p1, p2, index1 + 1, index2);


        return AppUtils.findLongestStr(inclusionSubsequence, exclusionSubSequence);

    }
}
