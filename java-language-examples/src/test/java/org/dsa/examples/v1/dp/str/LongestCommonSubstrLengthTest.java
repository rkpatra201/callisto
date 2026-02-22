package org.dsa.examples.v1.dp.str;

import org.dsa.examples.v1.dp.str.str._4LongestCommonSubstrLength;
import org.junit.Test;


public class LongestCommonSubstrLengthTest {

  @Test
  public void solution() {
    String p1 = "abc";
    String p2= "abc";
    int result = new _4LongestCommonSubstrLength().solution(p1, p2);
    System.out.println(result);
  }
}