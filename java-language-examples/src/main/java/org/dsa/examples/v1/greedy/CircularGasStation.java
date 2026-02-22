package org.dsa.examples.v1.greedy;

// https://www.youtube.com/watch?v=lJwbPZGo05A
// https://leetcode.com/problems/gas-station/submissions/1578606124/
// https://www.notion.so/Gas-Station-1bc85d61746d80458b1df3073ecc5515
public class CircularGasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (sum(gas) < sum(cost)) {
      return -1;
    }

    int total = 0;
    int index = 0;

    for (int i = 0; i < gas.length; i++) {
      total += (gas[i] - cost[i]);
      if (total < 0) {
        total = 0; // reset and try from next index
        index = i + 1;
      }
    }
    return index;
  }

  private int sum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }

}
