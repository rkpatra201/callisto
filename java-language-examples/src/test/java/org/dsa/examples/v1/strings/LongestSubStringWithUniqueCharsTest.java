package org.dsa.examples.v1.strings;

import org.dsa.examples.v1.strings.LongestSubStringWithUniqueChars;
import org.junit.Test;

public class LongestSubStringWithUniqueCharsTest {

  @Test
  public void solution() {
    String s = "abcabcd";
    LongestSubStringWithUniqueChars c = new LongestSubStringWithUniqueChars();
    int result = c.solution(s);
    System.out.println(result);
  }
}