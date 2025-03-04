package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

public class DiameterOfTree {

  int diameter = 0;

  public int solution(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int lh = solution(node.left);
    int rh = solution(node.right);

    diameter = Math.max(diameter, lh + rh);

    return Math.max(lh, rh) + 1;
  }
}
