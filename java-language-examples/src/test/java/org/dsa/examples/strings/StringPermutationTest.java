package org.dsa.examples.strings;

import java.util.List;

import org.junit.Test;

public class StringPermutationTest {

    @Test
    public void solution(){
       String input = "abc";
       List<String> result = new StringPermutation().solution(input); 
       System.out.println(result);
    }
}
