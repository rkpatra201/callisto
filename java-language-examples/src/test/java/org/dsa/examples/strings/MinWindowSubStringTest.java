package org.dsa.examples.strings;

import org.junit.Test;

import static org.junit.Assert.*;

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