package org.dsa.examples.v1.dp.str.str;

import org.dsa.examples.v1.dp.sum.AppUtils;

public class _5LongestCommonSubstrPrint {

    public String solution(String p1, String p2) {

        String commonLength = null;
        commonLength = solution(p1, p2, 0 , 0, "");
        return commonLength;
    }

    private String solution(String p1, String p2, int index1, int index2,  String maxLenStr) {
        if (index1 == p1.length() || index2 == p2.length()) {
            return maxLenStr;
        }

        // when match occurs reduce each string and increment maxLength by 1
        if (p1.charAt(index1) == p2.charAt(index2)) {
            return solution(p1, p2, index1 + 1, index2 + 1, maxLenStr + p1.charAt(index1));
        }

        // as no match occurred, next recursive calls will start with maxLength = 0

        // considering first string but reducing second string
        String firstString = solution(p1, p2, index1, index2 + 1,  "");
        // considering first string but reducing second string
        String secondString = solution(p1, p2, index1 + 1, index2, "");


        maxLenStr = AppUtils.findLongestStr(maxLenStr, firstString, secondString);

        return maxLenStr;


    }
}
