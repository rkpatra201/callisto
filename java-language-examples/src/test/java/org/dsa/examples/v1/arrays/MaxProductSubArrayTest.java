package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.MaxProductSubArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MaxProductSubArrayTest {


  private int[] input;
  private int expectedValue;

  public MaxProductSubArrayTest(int[] input, int expectedValue) {
    this.input = input;
    this.expectedValue = expectedValue;
  }


  @Parameterized.Parameters(name = "Test case {index}: input={0}, expected={1}")
  public static Collection<Object[]> data1() {
    return Arrays.asList(new Object[][]{
        {new int[]{1, 2, 3, -2, -8}, 96},  // Positive and negative numbers mixed, expected result is the maximum product
        {new int[]{1, 2, 3, -2, 8}, 8},  // Positive and negative numbers mixed, expected result is the maximum product
        {new int[]{1, 2, 3, 0, 2, 3, 4}, 24},  // Positive and zero numbers mixed, expected result is the maximum product
        {new int[]{-1, -2, -3}, 6},  // All negative numbers, expected result is the maximum product
        {new int[]{0, 0, 0, 2, 3}, 6},  // Array with zeros and positive numbers, expected result is the maximum product

        {new int[]{}, 0},  // Empty array, expected result is 0
        {new int[]{0}, 0},  // Array with a single element 0, expected result is 0
        {new int[]{5}, 5},  // Array with a single positive element, expected result is the element itself
        {new int[]{-5}, -5},  // Array with a single negative element, expected result is the element itself
        {new int[]{1, -2, 3, -4, 5}, 120},  // Array with alternating positive and negative numbers, expected result is the product of all elements
        {new int[]{0, 0, 0, 0}, 0},  // Array with all elements 0, expected result is 0
        {new int[]{2, -3, 0, -2, 4}, 4},  // Array with zeros and negative numbers, expected result is the product of the positive numbers only
    });
  }


  @Test
  public void solution() {
    MaxProductSubArray subArray = new MaxProductSubArray();
    int result = subArray.solution(input);
    Assert.assertEquals(result, expectedValue);
  }

}