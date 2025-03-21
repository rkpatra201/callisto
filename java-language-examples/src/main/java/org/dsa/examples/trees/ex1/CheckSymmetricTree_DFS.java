package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

public class CheckSymmetricTree_DFS {
  public boolean solution(TreeNode node){
    if(node == null) return false;
    return new CheckMirrorTree_DFS().solution(node.left, node.right);
  }
}
