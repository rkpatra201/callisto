package org.dsa.examples.v1.recursion;

import org.dsa.examples.v1.recursion.WordBreak2;
import org.junit.Test;

import java.util.List;

public class WordBreak2Test {

  @Test
  public void solution() {
    Object result = new WordBreak2().solution("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
    System.out.println(result);
  }
}