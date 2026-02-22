package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.Sort_0_1_2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class Sort_0_1_2Test {

  private int[] input;
  private int[] expectedValue;

  public Sort_0_1_2Test(int[] input, int[] expectedValue) {
    this.input = input;
    this.expectedValue = expectedValue;
  }


  @Parameterized.Parameters(name = "Test case {index}: input={0}, expected={1}")
  public static Collection<Object[]> data1() {
    return Arrays.asList(new Object[][]{
        {new int[]{2, 0, 1}, new int[]{0, 1, 2}},
        {new int[]{0, 1, 1, 2, 0, 1, 0, 2}, new int[]{0, 0, 0, 1, 1, 1, 2, 2}},
        {new int[]{0, 1, 2}, new int[]{0, 1, 2}},
        {new int[]{1, 0, 2}, new int[]{0, 1, 2}},
        {new int[]{0, 1, 1}, new int[]{0, 1, 1}},
        {new int[]{1, 1, 1}, new int[]{1, 1, 1}},
        {new int[]{1, 2, 2}, new int[]{1, 2, 2}},
    });
  }

  @Test
  public void solution() {
    Sort_0_1_2 sort_0_1_2 = new Sort_0_1_2();
    sort_0_1_2.solution(input);
    Assert.assertArrayEquals(expectedValue, input);
  }

  @Test
  public void solution_1() {
    Sort_0_1_2 sort_0_1_2 = new Sort_0_1_2();
    sort_0_1_2.solution_1(input);
    Assert.assertArrayEquals(expectedValue, input);
  }

  @Test
  public void solution_2() {
    Sort_0_1_2 sort_0_1_2 = new Sort_0_1_2();
    sort_0_1_2.solution_2(input);
    Assert.assertArrayEquals(expectedValue, input);
  }
}