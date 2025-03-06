package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

/**
 * The Maximum Path Sum in a binary tree problem involves finding the maximum sum of values along any path in the tree.
 * A path can start and end at any node but must follow parent-child connections.
 */
public class MaxPathSum_DFS {

  public static int solution(TreeNode treeNode) {
    traverse(treeNode);
    return maxSum;
  }

  private static int maxSum = Integer.MIN_VALUE;

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
