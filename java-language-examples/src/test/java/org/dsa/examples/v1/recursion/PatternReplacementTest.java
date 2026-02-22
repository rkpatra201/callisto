package org.dsa.examples.v1.recursion;

import org.dsa.examples.v1.recursion.PatternReplacement;
import org.junit.Test;

import java.util.List;

public class PatternReplacementTest {

  @Test
  public void solution() {
    String input = "x#y#z#";
    List<String> result = PatternReplacement.solution(input);
    System.out.println(result);
  }
}