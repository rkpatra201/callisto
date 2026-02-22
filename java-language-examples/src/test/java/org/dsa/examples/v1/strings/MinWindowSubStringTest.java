package org.dsa.examples.v1.strings;

import org.dsa.examples.v1.strings.MinWindowSubString;
import org.junit.Test;

public class MinWindowSubStringTest {

  @Test
  public void solution() {
    String s = "ddaaabbca";
    String t = "abc";

     s= "a";
     t = "b";
    MinWindowSubString m = new MinWindowSubString();
    String result = m.solution(s,t);
    System.out.println(result);
  }
}