package org.dsa.examples.v1.dp.str;

import org.dsa.examples.v1.dp.str.lcs._1LongestCommonSubsequenceLength;
import org.dsa.examples.v1.dp.str.lcs._2LongestCommonSubsequencePrint;
import org.junit.Test;


public class LongestCommonSubsequenceLengthTest {

    @Test
    public void solution() {
        String s1 = "abcefg";
        String s2 = "abckefl";

        int result = new _1LongestCommonSubsequenceLength().solution(s1,s2);
        System.out.println(result);

        String lcs = new _2LongestCommonSubsequencePrint().solution(s1,s2);
        System.out.println(lcs);
    }
}