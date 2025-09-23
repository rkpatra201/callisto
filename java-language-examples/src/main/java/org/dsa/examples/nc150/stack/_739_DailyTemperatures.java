package org.dsa.examples.nc150.stack;

// Difficulty: Medium. Need more practice
// Problem Statement: Given an array of integers temperatures representing the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
// Example 1:
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
// Example 2:
// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
// Example 3:
// Input: temperatures = [30,60,90]
// Output: [1,1,0]
// Constraints:
// 1 <= temperatures.length <= 10^5
// 30 <= temperatures[i] <= 100
// Follow up: Could you solve it in O(n) time complexity?

public class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int currentDayIndex = n - 1; currentDayIndex >= 0; currentDayIndex--) {
            int currentTemperatureVal = temperatures[currentDayIndex];
            // until you with big brother then kill all smaller brothers from stack
            while (!stack.isEmpty() && currentTemperatureVal >= temperatures[stack.peek()]) {
                stack.pop();
            }
            result[currentDayIndex] = stack.isEmpty() ? 0 : stack.peek() - currentDayIndex; // important to do this subtraction because we need number of days
            stack.push(currentDayIndex);
        }
        return result;
    }
}
