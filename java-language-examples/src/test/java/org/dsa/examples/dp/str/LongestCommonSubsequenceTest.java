package org.dsa.examples.dp.str;

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