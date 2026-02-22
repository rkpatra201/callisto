package org.dsa.examples.v1.dp.sum;

import org.dsa.examples.v1.dp.sum.CountSum_Recursion;
import org.junit.Test;

import java.util.ArrayList;


public class CountSum_RecursionTest {

    @Test
    public void solution() {
        int target = 7;
        int[] inputs = {2,3, 4};
        int result = new CountSum_Recursion().solution(target, inputs);
        System.out.println(result);

        result = new CountSum_Recursion().solution(target, inputs, new ArrayList<>());
        System.out.println(result);
    }


}