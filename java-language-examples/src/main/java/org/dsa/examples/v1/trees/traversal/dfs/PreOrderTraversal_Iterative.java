package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// D - L - R
public class PreOrderTraversal_Iterative {
  /**
   *  add root into stack
   *
   *  while stack is not empty
   *    pop node from stack. print it
   *    add right node to stack
   *    add left node to stack
   *
   * see right pushed to stack before left. so that left will come before right
   * @param treeNode
   * @return
   */
  public List<Integer> traverse(TreeNode treeNode) {
    List<Integer> list = new ArrayList<>();
    _traverse(treeNode, list);
    return list;
  }

  private void _traverse(TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode top = stack.pop();
      list.add(top.data);
      if (top.right != null) stack.push(top.right);
      if (top.left != null) stack.push(top.left);

    }

  }
}
