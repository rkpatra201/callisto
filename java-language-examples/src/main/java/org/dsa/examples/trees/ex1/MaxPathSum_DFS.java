package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

public class MaxPathSum_DFS {

  public static int solution(TreeNode treeNode) {
    traverse(treeNode);
    return maxSum;
  }

  private static int maxSum = 0;

  private static int traverse(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftSum = traverse(root.left);
    int rightSum = traverse(root.right);

    maxSum = Math.max(maxSum, leftSum + rightSum + root.data);

    return Math.max(leftSum, rightSum) + root.data;

  }

}
