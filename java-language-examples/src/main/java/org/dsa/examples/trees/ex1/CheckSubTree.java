package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

// https://leetcode.com/problems/subtree-of-another-tree/submissions/1581509646/
public class CheckSubTree {

  public boolean solution(TreeNode source, TreeNode target){
    if(source == null) return false; // a null source cant contain a target tree. so return false

    boolean result = new CheckSameTree_DFS().solution(source, target);
    if(result) return result;

    return solution(source.left, target) || solution(source.right, target);
  }
}
