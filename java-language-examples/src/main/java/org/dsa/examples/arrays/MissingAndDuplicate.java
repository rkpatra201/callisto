package org.dsa.examples.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingAndDuplicate {

    public int[] solution(int[] arr){
        // find missing and duplicate
        return null;
    }
    public static void main(String[] args) {
        int [] arr = IntStream.range(1, 11).toArray();
//        arr[0] = 3;

        System.out.println(Arrays.toString(arr));

        int xorArr = 0;
        for(int num: arr){
            xorArr ^=num;
        }

        System.out.println(xorArr);

        int xorAll = 0;
        for(int i=1; i<= arr.length; i++){
             xorAll ^= i;
        }

        System.out.println(xorAll);

        System.out.println(xorAll ^ xorArr);
    }
}
