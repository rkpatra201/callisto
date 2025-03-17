package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

public class ValidBstTree_DFS {

  public static boolean solution(TreeNode root) {
     return traverse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean traverse(TreeNode root, int min, int max){
    if(root == null){
      return true;
    }
    return root.data > min && root.data < max
        && traverse(root.left, min, root.data)
        && traverse(root.right, root.data, max);

  }
}
