package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal_Iterative {

  /**
   * @param treeNode
   * @return
   */
  public List<Integer> traverse(TreeNode treeNode) {
    List<Integer> list = new ArrayList<>();
    _traverse(treeNode, list);
    return list;
  }

  private void _traverse(TreeNode treeNode, List<Integer> list) {
    if (treeNode == null)
      return;
    Stack<TreeNode> stack = new Stack<>();

    while (true) {
      while (treeNode != null) {
        stack.add(treeNode);
        treeNode = treeNode.left; // left
      }
      if (stack.isEmpty()) break;
      TreeNode pop = stack.pop();
      list.add(pop.data); // data
      treeNode = pop.right; // right
    }
  }
}
