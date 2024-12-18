package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

public class Sum_All_Node_Values_DFS {

  public static int solution(TreeNode root) {

    int result = traverse(root);
    System.out.println(result);
    return result;

  }

  private static int traverse(TreeNode treeNode) {
    if (treeNode == null) return 0;
    int leftSum = traverse(treeNode.left);
    int rightSum = traverse(treeNode.right);
    return leftSum + rightSum + treeNode.data;
  }
}
