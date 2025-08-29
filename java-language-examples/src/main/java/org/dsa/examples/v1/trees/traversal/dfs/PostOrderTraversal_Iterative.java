package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * important and tricky
 */
public class PostOrderTraversal_Iterative {


  /**
   * take a stack
   * start with while true
   * 1. keep pushing root and update root=root.left. at some point root is null
   * 1.1. if stack empty break
   * 2. when root is not matching right of stack pop, set root=stack.peek.right. go to step 1
   * 3. otherwise root = stack.pop and print root.data
   *
   * @param treeNode
   * @return
   */
  public List<Integer> traverse(TreeNode treeNode) {
    List<Integer> list = new ArrayList<>();
    _traverse(treeNode, list);
    return list;
  }

  private void _traverse(TreeNode root, List<Integer> list) {
    Stack<TreeNode> stack = new Stack<>();
    boolean flag = true;
    while (true) {
      while (root != null && flag) { // left
        stack.add(root);
        root = root.left; // add root into stack & keep moving to left until root becomes null
      }
      if (stack.isEmpty()) break;

      // here root is null or flag is false or both can happen
      // right
      if (root != stack.peek().right) { // when root doesnt match with stack->top->right
        root = stack.peek().right;
        flag = true;
        continue;
      }

      // otherwise stack po and set to root
      root = stack.pop();
      list.add(root.data); // data
      flag = false;


    }
  }

}
