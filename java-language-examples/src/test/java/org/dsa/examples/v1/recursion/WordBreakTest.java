package org.dsa.examples.v1.recursion;

import org.dsa.examples.v1.recursion.WordBreak;
import org.junit.Test;

import java.util.List;

public class WordBreakTest {

  @Test
  public void solution() {
    boolean result = new WordBreak().solution("leetcode", List.of("leet", "code"));
    System.out.println(result);
  }
}