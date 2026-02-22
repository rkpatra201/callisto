package org.dsa.examples.lc.dp.sequence;

import org.dsa.examples.v1.dp.sum.AppUtils;

public class _3LongestCommonSubsequence3Str {

  public int solution(String p1, String p2, String p3) {

    int commonLength = 0;
    commonLength = solution(p1, p2, p3, 0, 0, 0);
    return commonLength;
  }

  private int solution(String p1, String p2, String p3, int index1, int index2, int index3) {

    if (index1 == p1.length() || index2 == p2.length() || index3 == p3.length()) {
      return 0;
    }

    // when match occurs reduce each string and increment maxLength by 1
    if (p1.charAt(index1) == p2.charAt(index2) && p1.charAt(index1) == p3.charAt(index2)) {
      return 1 + solution(p1, p2, p3, index1 + 1, index2 + 1, index3 + 1);
    }
    // as no match occurred, next recursive calls will start with maxLength = 0

    // considering first string but reducing second string
    int firstString = solution(p1, p2, p3, index1 + 1, index2, index3);
    // considering first string but reducing second string
    int secondString = solution(p1, p2, p3, index1, index2 + 1, index3);

    int thirdString = solution(p1, p2, p3, index1, index2 + 1, index3);

    int result = AppUtils.max(firstString, secondString, thirdString);

    return result;

  }
}
