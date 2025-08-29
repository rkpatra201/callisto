package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.traversal.TreeNode;

public class MaxPathSum_Recursion {

  public static int solution(TreeNode treeNode){
    int result = 0;
    result = iterate(treeNode);
    return result;
  }

  private static int iterate(TreeNode treeNode){

    if(treeNode == null){
      return 0;
    }
    int left = iterate(treeNode.left);
    int right = iterate(treeNode.right);

    return Math.max(left, right) + treeNode.data;
  }
  public static int getResult(TreeNode treeNode) {
    traverse(treeNode, 0);
    return maxSum;
  }

  private static int maxSum = 0;

  /**
   * The root parameter represents the current node being processed,
   * and currentSum represents the sum of values along the path from the root to the current node.
   *
   * The base case for the recursion is when the current node is null,
   * in which case the method simply returns.
   *
   * If the current node is a leaf node (i.e., has no children),
   * then the maxSum variable (presumably a class-level variable) is
   * updated to the maximum of its current value and the currentSum.
   *
   * Finally, the method recursively calls itself
   * on the left and right children of the current node, passing along the updated currentSum.
   *
   * @param root
   * @param currentSum
   */
  private static void traverse(TreeNode root, int currentSum) {
    if (root == null) {
      return;
    }
    currentSum = currentSum + root.data;
    if (root.left == null && root.right == null) {
      maxSum = Math.max(maxSum, currentSum);
    }
    traverse(root.left, currentSum);
    traverse(root.right, currentSum);
  }
}
