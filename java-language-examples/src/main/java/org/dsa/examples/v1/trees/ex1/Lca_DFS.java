package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.TreeNode;

public class Lca_DFS {

  public static TreeNode solution(TreeNode root, TreeNode node1, TreeNode node2){
    return traverse(root, node1, node2);
  }

  private static TreeNode traverse(TreeNode root, TreeNode node1, TreeNode node2){
    if(root == null || root.data == node1.data || root.data == node2.data){
      return root;
    }

    TreeNode left = traverse(root.left, node1, node2);
    TreeNode right = traverse(root.right, node1, node2);

    if(left == null){
      return right;
    }
    else if(right == null){
      return left;
    }
    return root;
  }

}
