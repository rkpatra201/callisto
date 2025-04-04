package org.dsa.examples.v1.graph;

import org.dsa.examples.v1.graph.v1.WordLadder1;
import org.junit.Test;

import java.util.List;

public class WordLadder1Test {

  @Test
  public void ladderLength() {
    int result = new WordLadder1().ladderLength("a", "c", List.of("a", "b", "c"));
    System.out.println(result);
  }
}