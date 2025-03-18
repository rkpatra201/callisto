package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

/**
 * The Maximum Path Sum in a binary tree problem involves finding the maximum sum of values along any path in the tree.
 * A path can start and end at any node but must follow parent-child connections.
 */
// https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/1577456217/
public class MaxPathSum_DFS {

  public static int solution(TreeNode treeNode) {
    traverse(treeNode);
    return maxSum;
  }

  private static int maxSum = Integer.MIN_VALUE;

  public static int traverse(TreeNode root){
    if(root == null){
      return 0;
    }

    int l = Math.max(0, traverse(root.left));
    int r = Math.max(0, traverse(root.right));

    maxSum = Math.max(maxSum, l+r+root.data);

    return Math.max(l,r) + root.data;
  }

}
