package org.dsa.examples.nc150.stack;

// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
import java.util.*;
class _GFG_NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> s = new Stack();
        ArrayList<Integer> list = new ArrayList();
        for(int i = arr.length -1 ; i >=0 ; i--){
            int current = arr[i];
            while(!s.isEmpty() && current >= s.peek()){ // this >= important
                s.pop();
            }
            int res  = s.isEmpty() ? -1 : s.peek();
            list.add(res);
            s.push(current);
        }
        Collections.reverse(list); // this reverse is important for ordering
        return list;
    }
}