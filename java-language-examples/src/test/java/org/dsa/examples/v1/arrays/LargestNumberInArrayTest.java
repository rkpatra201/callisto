package org.dsa.examples.v1.arrays;


import org.dsa.examples.v1.arrays.LargestNumberInArray;
import org.junit.Assert;
import org.junit.Test;

public class LargestNumberInArrayTest {

    @Test
    public void solution() {
        int arr[] = {1, 5, 3, 7, 8, 9, 12, 0, 9, 8};
        LargestNumberInArray largestNumberInArray = new LargestNumberInArray();
        int actualValue = largestNumberInArray.solution(arr);
        Assert.assertEquals(12, actualValue);
    }
}