package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

public class SubTree_DFS {
  public boolean solution(TreeNode source, TreeNode target) {
    if (target == null) return true;
    if (source == null) return false;

    if (isSameTree(source, target)) {
      return true;
    }
    return solution(source.left, target) || solution(source.right, target);
  }

  private boolean isSameTree(TreeNode source, TreeNode target) {
    if(source == null && target == null) return true;
    if(source == null || target == null) return false;

    return
        source.data == target.data
        && isSameTree(source.left, target.left)
        && isSameTree(source.right, target.right);
  }
}
