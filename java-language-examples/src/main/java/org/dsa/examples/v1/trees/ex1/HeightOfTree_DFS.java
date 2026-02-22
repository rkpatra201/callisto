package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.TreeNode;

// The height of a tree is the [length of the path from the root to the deepest node] in the tree
// Math.max(left, height) + 1
// height of single node = 0, full binary tree number of nodes = 2^h+1 -1
// 1 = 2^h+1 -1 => 2 = 2^h+1 => h+1 = 1 => h = 0
public class HeightOfTree_DFS {

  public static int solution(TreeNode root) {
    return traverse(root);
  }

  private static int traverse(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) { // leaf node (single node)
      return 0;
    }
    int lh = traverse(root.left);
    int rh = traverse(root.right);

    return Math.max(lh, rh) + 1;
  }
}
