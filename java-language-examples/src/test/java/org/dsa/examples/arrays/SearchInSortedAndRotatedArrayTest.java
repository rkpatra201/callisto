package org.dsa.examples.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInSortedAndRotatedArrayTest {

  @Test
  public void solution() {
    int[] sortedArray = {};
    int[] sortedRotatedArray = {23, 38, 56, 72, 91, 2, 5, 8, 12, 16};

    SearchInSortedAndRotatedArray search = new SearchInSortedAndRotatedArray();
    int index = search.solution(sortedRotatedArray, 72);
    Assert.assertSame(3, index);
    index = search.solution(sortedRotatedArray, 91);
    Assert.assertSame(4, index);
    index = search.solution(sortedRotatedArray, 12);
    Assert.assertSame(8, index);
    index = search.solution(sortedRotatedArray, 89);
    Assert.assertSame(-1, index);
  }
}