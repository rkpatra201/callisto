package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// deepest node is the end node in BFS.
// For each level we can increment height to know height of tree
public class DeepestNode_BFS {


  public static TreeNode solution(TreeNode root) {
    System.out.println("height: "+height);
    return deepestNode;
  }

  private static Queue<TreeNode> queue = new LinkedList<>();

  private static int height = 0;

  private static TreeNode deepestNode = null;

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

      deepestNode = current;

      if (current.left != null)
        queue.add(current.left);

      if (current.right != null)
        queue.add(current.right);

    }
    return height;
  }
}
