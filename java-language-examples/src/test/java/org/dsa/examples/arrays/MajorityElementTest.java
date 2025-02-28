package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {

  @Test
  public void solution() {
    int[] arr = {1, 1, 2, 3, 2,1, 2, 4,4,4,4,4,4};
    MajorityElement element = new MajorityElement();
    int result = element.solution(arr);
    Assert.assertEquals(result,2);
  }
}