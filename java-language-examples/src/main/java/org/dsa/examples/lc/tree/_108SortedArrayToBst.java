package org.dsa.examples.lc.tree;
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/1609650263/
public class _108SortedArrayToBst {
  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(nums, 0, nums.length - 1);
  }

  private TreeNode dfs(int[] nums, int start, int end) {

    if (start > end) {
      return null;
    }

    int m = (start + end) / 2;

    TreeNode root = new TreeNode(nums[m]);
    root.left = dfs(nums, start, m - 1);
    root.right = dfs(nums, m + 1, end);

    return root;
  }
}
