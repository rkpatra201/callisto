package org.dsa.examples.blind75._9tree;

import org.dsa.examples.v1.trees.traversal.TreeNode;

// in order
public class _230KthSmallestBst {
  public int kthSmallest(TreeNode root, int k) {
    result = -1;
    dfs(root, k);
    return result;
  }

  private int pos = 0;
  private int result = -1;

  public int dfs(TreeNode root, int k) {
    if (root == null || result != -1) {
      return -1;
    }

    dfs(root.left, k);

    int t = pos + 1;
    System.out.println(k + ":" + t + ":" + root.data);
    if (k == t && result == -1) {
      result = root.data;
      System.out.println(result);
    }
    pos++;

    dfs(root.right, k);
    return result;
  }
}
