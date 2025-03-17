package org.dsa.examples.recursion;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordBreak2Test {

  @Test
  public void solution() {
    Object result = new WordBreak2().solution("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
    System.out.println(result);
  }
}