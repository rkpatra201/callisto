package org.dsa.examples.v1.trees.traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TraversalUtils {

  public List<Integer> left_view_traverse(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int q_size = queue.size();
      int index = 0;
      boolean elementFound = false;
      while (index < q_size) {
        TreeNode currentNode = queue.pollFirst();
        if (!elementFound) {
          list.add(currentNode.data);
          elementFound = true;
        }
        if (currentNode.left != null) queue.addLast(currentNode.left);
        if (currentNode.right != null) queue.addLast(currentNode.right);
        index++;
      }
    }
    return list;
  }


  public List<Integer> right_view_traverse(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int q_size = queue.size();
      int index = 0;
      boolean elementFound = false;
      while (index < q_size) {
        TreeNode currentNode = queue.pollLast();
        if (!elementFound) {
          list.add(currentNode.data);
          elementFound = true;
        }
        if (currentNode.right != null) queue.addFirst(currentNode.right);
        if (currentNode.left != null) queue.addFirst(currentNode.left);
        index++;
      }
    }
    return list;
  }




  /**
   * add root node to deque
   * for a level readFirst and addLast
   * for a level readLast and addFirst
   *
   * <pre>
   *                            40
   *                    20             60
   *               10       30     50      80
   * </pre>
   */
  public List<List<Integer>> zig_zag_order_traverse(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean leftToRight = true;
    while (!queue.isEmpty()) {
      int q_size = queue.size();
      int index = 0;
      List<Integer> level_data = new ArrayList<>();
      while (index < q_size) {
        int data = -1;
        if (leftToRight) {
          data = processLeftToRight(queue);
        } else {
          data = processRightToLeft(queue);
        }
        index++;
        if (data != -1) {
          level_data.add(data);
        }
      }
      list.add(level_data);
      leftToRight = !leftToRight;
    }
    return list;
  }

  // read last and add first
  private int processRightToLeft(Deque<TreeNode> deque) {
    TreeNode currentNode = deque.pollLast();
    addFirst(deque, currentNode.right);
    addFirst(deque, currentNode.left);
    return currentNode.data;
  }

  // read first and add last
  private int processLeftToRight(Deque<TreeNode> deque) {
    TreeNode currentNode = deque.pollFirst();
    addLast(deque, currentNode.left);
    addLast(deque, currentNode.right);
    return currentNode.data;
  }

  private void addLast(Deque<TreeNode> deque, TreeNode treeNode) {
    if (treeNode != null)
      deque.addLast(treeNode);
  }

  private void addFirst(Deque<TreeNode> deque, TreeNode treeNode) {
    if (treeNode != null)
      deque.addFirst(treeNode);
  }


  public List<Integer> diagonal_order_traverse() {
    return null;
  }

}
