package org.dsa.examples.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaxSumSubArrayTest {

  private int[] input;
  private int expected;

  public MaxSumSubArrayTest(int[] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters(name = "Test case: input={0}, expected={1}")
  public static Collection<Object[]> testCases() {
    return Arrays.asList(new Object[][]{
        {new int[]{1, 2, 3, 4, 5}, 15}, // Array with positive numbers
        {new int[]{-1, -2, -3, -4, -5}, 0}, // Array with negative numbers
        {new int[]{1, -2, 3, -4, 5}, 5}, // Array with a mix of positive and negative numbers
        {new int[]{}, 0}, // Empty array
        {new int[]{0}, 0}, // Array with a single element 0
        {new int[]{-1}, 0}, // Array with a single negative element
        {new int[]{5}, 5}, // Array with a single positive element
        {new int[]{-2, -3, 4, -1, -2, 1, 5, -3}, 7} // Array with both positive and negative numbers
    });
  }

  @Test
  public void testMaxSumSubArray() {
    MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
    int result = maxSumSubArray.solution(input);
    assertEquals(expected, result);
  }
}
