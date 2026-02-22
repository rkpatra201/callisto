package org.dsa.examples.v1.dp.str;

import org.dsa.examples.v1.dp.str.LongestCommonSubsequence;
import org.junit.Test;


public class LongestCommonSubsequenceTest {

    @Test
    public void solution() {
        String s1 = "abcefg";
        String s2 = "abckl";

        int result = new LongestCommonSubsequence().solution(s1,s2);
        System.out.println(result);
    }
}