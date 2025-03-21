package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

// https://leetcode.com/problems/same-tree/submissions/1576418737/
public class CheckSameTree_DFS {
  public boolean solution(TreeNode source, TreeNode target) {
    if (source == null && target == null) return true;
    if (source == null || target == null) return false;
    return
        source.data == target.data
            && solution(source.left, target.left)
            && solution(source.right, target.right);
  }
}
