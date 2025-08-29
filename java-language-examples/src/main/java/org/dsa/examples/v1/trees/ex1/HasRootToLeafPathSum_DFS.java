package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.TreeNode;

public class HasRootToLeafPathSum_DFS {

  public static boolean solution(TreeNode root, int sum){
    return traverse(root, sum);
  }

  private static boolean traverse(TreeNode treeNode, int sum){
    if(treeNode == null){
      return false;
    }
    int remainSum = sum - treeNode.data;
    if(treeNode.left == null && treeNode.right==null && remainSum == 0)// a leaf node where remainSum is 0
    {
      return true;
    }
    return traverse(treeNode.left, remainSum) || traverse(treeNode.right, remainSum);
  }
}
