package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.TreeNode;

public class CheckMirrorSubTree {

  public boolean solution(TreeNode source, TreeNode target){
    if(source == null) return true;
    if(target == null) return false;

    boolean result = new CheckMirrorTree_DFS().solution(source, target);
    if(result) return result;

    return solution(source.left, target) || solution(target.right, target);
  }
}
