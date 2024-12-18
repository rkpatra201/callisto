package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindPeakElementTest {

  @Test
  public void solution() {
    int[] arr = {1, 3, 5, 4, 2}; // peak element is at middle
    FindPeakElement peakElement = new FindPeakElement();
    int peakIndex = peakElement.solution(arr);
    int actualValue = arr[peakIndex];
    int expectedValue = 5;
    Assert.assertEquals(expectedValue, actualValue);
  }

  @Test
  public void solution_1() {
    int[] arr = {1, 3, 5, 4, 2, 1, 0}; // peak element is at left
    FindPeakElement peakElement = new FindPeakElement();
    int peakIndex = peakElement.solution(arr);
    int actualValue = arr[peakIndex];
    int expectedValue = 5;
    Assert.assertEquals(expectedValue, actualValue);
  }

  @Test
  public void solution_1_1() {
    int[] arr = {5, 4, 2, 1, 0}; // peak element is at extreme left
    FindPeakElement peakElement = new FindPeakElement();
    int peakIndex = peakElement.solution(arr);
    int actualValue = arr[peakIndex];
    int expectedValue = 5;
    Assert.assertEquals(expectedValue, actualValue);
  }

  @Test
  public void solution_2() {
    int[] arr = {1, 2, 3, 5, 4}; // peak element is at right
    FindPeakElement peakElement = new FindPeakElement();
    int peakIndex = peakElement.solution(arr);
    int actualValue = arr[peakIndex];
    int expectedValue = 5;
    Assert.assertEquals(expectedValue, actualValue);
  }

  @Test
  public void solution_2_1() {
    int[] arr = {1, 2, 3, 4, 5}; // peak element is at extreme right
    FindPeakElement peakElement = new FindPeakElement();
    int peakIndex = peakElement.solution(arr);
    int actualValue = arr[peakIndex];
    int expectedValue = 5;
    Assert.assertEquals(expectedValue, actualValue);
  }


}