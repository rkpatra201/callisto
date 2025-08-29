package org.dsa.examples.v1.arrays;

import org.dsa.examples.v1.arrays.MajorityElement;
import org.junit.Assert;
import org.junit.Test;

public class MajorityElementTest {

  @Test
  public void solution() {
    int[] arr = {1, 1, 2, 3, 2,1, 2, 4,4,4,4,4,4};
    MajorityElement element = new MajorityElement();
    int result = element.majorityElement(arr);
    Assert.assertEquals(result,2);
  }
}