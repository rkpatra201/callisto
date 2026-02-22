package org.dsa.examples.v1.dp.str;

import org.dsa.examples.v1.dp.str.lis._6LongestIncreaseSubSequence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestIncreaseSubSequenceTest {

  private int[] input;
  private List<Integer> expectedOutput;

  public LongestIncreaseSubSequenceTest(int[] input, List<Integer> expectedOutput) {
    this.input = input;
    this.expectedOutput = expectedOutput;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{10, 9, 2, 5, 3, 7, 101, 18}, Arrays.asList(2, 3, 7, 18)},
        {new int[]{0, 1, 0, 3, 2, 3}, Arrays.asList(0, 1, 2, 3)},
        {new int[]{3, 10, 2, 1, 20}, Arrays.asList(3, 10, 20)},
        {new int[]{50, 3, 10, 7, 40, 80}, Arrays.asList(3, 7, 40, 80)},
        {new int[]{40, 80, 41, 42}, Arrays.asList(40, 41, 42)},
        {new int[]{1, 2, 3, 4, 5}, Arrays.asList(1, 2, 3, 4, 5)} // Already increasing
    });
  }

  @Test
  public void testSolution() {
    _6LongestIncreaseSubSequence lis = new _6LongestIncreaseSubSequence();
    List<Integer> result = lis.solution(input);  // Calling your `solution` method
    assertEquals(expectedOutput, result);
  }
}