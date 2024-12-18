package org.dsa.examples.trees.traversal.dfs;

import org.dsa.examples.trees.traversal.TreeNode;

public class ConvertToMirrorTree_Recursive {
  public void solution(TreeNode node){
    if(node!=null){

      solution(node.left);
      solution(node.right);

      // swap after reaching depth
      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
    }
  }
}
