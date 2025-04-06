package org.dsa.examples.blind75._10heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
// https://leetcode.com/problems/top-k-frequent-elements/submissions/1597878995/
public class TopKElements {
  public static void main(String[] args) {
    TopKElements el = new TopKElements();
    int[] nums = {1, 1, 2, 2, 2, 3, 3, 3, 3};
    el.topKFrequent(nums, 2);
  }

  private static class Pair {
    int value;
    int frequency;

    public int getFrequency() {
      return frequency;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "value=" + value +
          ", frequency=" + frequency +
          '}';
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getFrequency).reversed());
    Map<Integer, Pair> mappings = new HashMap<>();
    for (int i : nums) {
      if (mappings.containsKey(i)) {
        Pair p = mappings.get(i);
        pq.remove(p);
        p.frequency = p.frequency + 1;
        pq.add(p);
      } else {
        Pair p = new Pair();
        p.value = i;
        p.frequency = 1;
        mappings.put(i, p);
        pq.add(p);
      }
    }

    System.out.println(pq);
    System.out.println(mappings);
    int[] result = new int[k];
    int i = 0;
    while (!pq.isEmpty()) {
      int v = pq.poll().value;
      result[i++] = v;
      if (i == result.length) {
        break;
      }
    }
    return result;
  }

}
