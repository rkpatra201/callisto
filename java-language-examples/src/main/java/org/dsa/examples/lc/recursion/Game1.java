package org.dsa.examples.lc.recursion;


public class Game1 {
  public static void main(String[] args) {
    boolean result = new Game1().canJump(new int[]{2,0,0});
    System.out.println(result);
  }
  public boolean canJump(int[] nums) {
    return recurse(0, nums);
  }

  public boolean recurse(int next, int[] nums) {
    if (next >= nums.length - 1) {
      return true;
    }

    boolean flag = false;
    int prevIndex = -1;
    while (next < nums.length) {
      prevIndex = next;
      int v = nums[next];
      int newLoc = next + v;
      next = newLoc;
      System.out.println(newLoc);
      if(newLoc >= nums.length-1){
        return true;
      }
      if (newLoc == prevIndex) {
        return false;
      }
      flag = flag || recurse(next, nums);
    }
    return flag;
  }

}
