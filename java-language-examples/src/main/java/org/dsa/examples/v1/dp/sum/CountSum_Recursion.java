package org.dsa.examples.v1.dp.sum;

import java.util.ArrayList;
import java.util.List;

public class CountSum_Recursion {
    public int solution(int target, int[] arr){
        if(target == 0) return 1;
        if(target < 0) return 0;
        int count = 0;
        for(int item: arr){
            int rem = target - item;
            count = count + solution(rem, arr);
        }
        return count;
    }

    public int solution(int target, int[] arr, List<Integer> current){
        if(target == 0) {
            System.out.println(current);
            return 1;
        }
        if(target < 0) return 0;
        int count = 0;
        for(int item: arr){
            int rem = target - item;
            List<Integer> currentCopy = new ArrayList<>(current);
            currentCopy.add(item);
            count = count + solution(rem, arr, currentCopy);
        }
        return count;
    }
}
