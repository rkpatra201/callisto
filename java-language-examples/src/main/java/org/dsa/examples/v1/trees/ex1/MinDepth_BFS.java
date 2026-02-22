package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// increment height in each level and
// return height when first leaf node found

public class MinDepth_BFS {

  public static int solution(TreeNode root) {
    return traverse(root);
  }

  private static Queue<TreeNode> queue = new LinkedList<>();

  private static int height = 0;

  private static int traverse(TreeNode node) {
    if (node == null) {
      return -1;
    }
    queue.add(node);queue.add(null);
    while (!queue.isEmpty()) {

      TreeNode current = queue.poll();

      if (current == null) { // traversing to next level
        height = height + 1;
        queue.add(null);
        continue;
      }

      if (current.left == null && current.right == null) { // first leaf node found
        return height;
      }

      if (current.left != null)
        queue.add(current.left);

      if (current.right != null)
        queue.add(current.right);

    }
    return height;
  }
}
