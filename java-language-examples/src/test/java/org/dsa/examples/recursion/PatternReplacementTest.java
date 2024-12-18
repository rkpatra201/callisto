package org.dsa.examples.recursion;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PatternReplacementTest {

  @Test
  public void solution() {
    String input = "x#y#z#";
    List<String> result = PatternReplacement.solution(input);
    System.out.println(result);
  }
}