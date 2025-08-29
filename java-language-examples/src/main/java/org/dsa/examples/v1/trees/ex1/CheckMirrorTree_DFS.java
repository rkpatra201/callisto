package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.TreeNode;

public class CheckMirrorTree_DFS {

  public boolean solution(TreeNode source, TreeNode target){
    if(source == null && target == null) return true;
    if(source == null || target == null) return false;

    return source.data == target.data
        && solution(source.left, target.right)
        && solution(source.right, target.left);

  }
}
