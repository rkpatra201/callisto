package org.dsa.examples.nc150.stack;

public class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int current = temperatures[i];
            // until you with big brother then kill all smaller brothers from stack
            while (!stack.isEmpty() && current >= temperatures[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
