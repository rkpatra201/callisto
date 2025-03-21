package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

public class ConvertToMirrorTree_DFS {
  public TreeNode solution(TreeNode node){
    if(node == null) return null;

    // swapping to convert to a mirror tree
    TreeNode temp = node;
    node.right = node.left;
    node.left = temp;

    // traverse left and right
    solution(node.left);
    solution(node.right);

    return node;
  }
}
