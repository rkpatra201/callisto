package org.dsa.examples.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubStringWithUniqueCharsTest {

  @Test
  public void solution() {
    String s = "abcabcd";
    LongestSubStringWithUniqueChars c = new LongestSubStringWithUniqueChars();
    int result = c.solution(s);
    System.out.println(result);
  }
}