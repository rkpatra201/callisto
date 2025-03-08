package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSum_All_Approaches {
  public static void main(String[] args) {
    int[] inputs = new int[]{1,2,5};
    int target = 8;

    System.out.println("==== can construct ====");
    boolean canConstruct = canConstruct(inputs, target);
    System.out.println(canConstruct);

    System.out.println("==== count construct ====");
    int result = countConstruct(inputs, target);
    System.out.println(result);

    System.out.println("=== print one construct ====");
    List<Integer> combinations = howConstruct1(inputs, target);
    System.out.println(combinations);

    System.out.println("=== print largest construct ====");
    List<Integer> largest = largestConstruct(inputs, target);
    System.out.println(largest);

    System.out.println("=== print all construct ====");
    howAllConstruct(inputs, target, new ArrayList<>());

    System.out.println("=== print all uk construct ====");
    inputs = new int[]{1,1,2,5,6,7,10};// put in set and then sort for uk
    howAllUniqueConstruct(inputs, target, new ArrayList<>(), 0);

  }

  private static int[] memoCountConstruct = null;

  private static int countConstruct(int[] nums, int target) {

    if (target < 0) return 0;
    if (target == 0) return 1;

    if (memoCountConstruct == null) {
      memoCountConstruct = new int[target + 1];
      Arrays.fill(memoCountConstruct, -1);
    }

    if (memoCountConstruct[target] != -1) {
      return memoCountConstruct[target];
    }


    int totalWays = 0;
    for (int i : nums) {
      int newTarget = target - i;
      totalWays = totalWays + countConstruct(nums, newTarget);
    }

    memoCountConstruct[target] = totalWays;
    return totalWays;
  }

  private static boolean[] memoCanContruct = null;

  private static boolean canConstruct(int[] nums, int target) {
    if (target < 0) return false;


    if (memoCanContruct == null) {
      memoCanContruct = new boolean[target + 1];
      Arrays.fill(memoCanContruct, false);
    }

    if (memoCanContruct[target]) {
      return memoCanContruct[target];
    }

    if (target == 0) return true;

    boolean canConstruct = false;
    for (int i : nums) {
      int newTarget = target - i;
      canConstruct = canConstruct || canConstruct(nums, newTarget);
//      System.out.println(totalWays);
    }

    memoCanContruct[target] = canConstruct;
    return canConstruct;
  }

  private static void howAllConstruct(int[] nums, int target, List<Integer> paths) {
    if (target < 0) return;
    if (target == 0) {
      System.out.println(paths);
      return;
    }

    for (int i : nums) {
      paths.add(i);
      int newTarget = target - i;
      howAllConstruct(nums, newTarget, paths);
      paths.remove(paths.size() - 1);
    }
  }



  private static void howAllUniqueConstruct(int[] nums, int target, List<Integer> paths, int startIndex) {
    if (target < 0) return;
    if (target == 0) {
      System.out.println(paths);
      //return;
    }

    for (int i = startIndex; i < nums.length; i++) {
      paths.add(nums[i]);
      howAllUniqueConstruct(nums, target - nums[i], paths, i + 1); // Move to next index
      paths.remove(paths.size() - 1);
    }
  }


  // this returns the first construct always due to early retrun we dont explore all ways
  private static Object[] memoHowConstruct1 = null;

  private static List<Integer> howConstruct1(int[] nums, int target) {
    if (target < 0) return null;

    if (memoHowConstruct1 == null) {
      memoHowConstruct1 = new Object[target + 1];
    }

    if (memoHowConstruct1[target] != null) {
      return (List<Integer>) memoHowConstruct1[target];
    }
    if (target == 0) {
      return new ArrayList<>();
    }

    for (int i : nums) {
      int newTarget = target - i;
      List<Integer> result = howConstruct1(nums, newTarget);
      if (result != null) {
        List<Integer> newList = new ArrayList<>(result);
        newList.add(0, i);
        memoHowConstruct1[target] = newList;
        return newList;
      }
    }
    memoHowConstruct1[target] = null;
    return (List<Integer>) memoHowConstruct1[target];
  }

  private static Object[] memoLargestConstruct = null;

  private static List<Integer> largestConstruct(int[] inputs, int target) {
    if (target < 0) return null;

    if (memoLargestConstruct == null) {
      memoLargestConstruct = new Object[target + 1];
    }

    if (memoLargestConstruct[target] != null) {
      return (List<Integer>) memoLargestConstruct[target];
    }

    if (target == 0) return new ArrayList<>();

    List<Integer> largestConstruct = null;

    for (int i : inputs) {
      int newTarget = target - i;
      List<Integer> result = largestConstruct(inputs, newTarget);
      if (result != null) {
        List<Integer> newList = new ArrayList<>(result);
        newList.add(0, i);
        if (largestConstruct == null || largestConstruct.size() < newList.size()) {
          largestConstruct = newList;
        }
      }
    }
    memoLargestConstruct[target] = largestConstruct == null ? null : new ArrayList<>(largestConstruct);
    return (List<Integer>) memoLargestConstruct[target];
  }
}
