package org.dsa.examples.recursion;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {

  @Test
  public void solution() {
    boolean result = new WordBreak().solution("leetcode", List.of("leet", "code"));
    System.out.println(result);
  }
}