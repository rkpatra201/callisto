package org.dsa.examples.lc.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _987VerticalOrderTraversal {

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(10);
    TreeNode n2 = new TreeNode(20);
    TreeNode n3 = new TreeNode(30);
    TreeNode n4 = new TreeNode(40);
    TreeNode n5 = new TreeNode(50);
    n1.left = n2;
    n1.right = n3;
    n3.right = n4;
    n2.right = n5;

    Object obj = new _987VerticalOrderTraversal().verticalTraversal(n1);
    System.out.println(obj);
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    hdMap.put(root, 0);
    results.computeIfAbsent(hdMap.get(root), k -> new ArrayList<>()).add(root.val);
    bfs(root);
    return new ArrayList<>(results.values());
  }

  private Map<TreeNode, Integer> hdMap = new HashMap<>();
  private Map<Integer, List<Integer>> results = new TreeMap<>(Comparator.naturalOrder());

  private void bfs(TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
         root = queue.poll();
        if (root.left != null) {
          hdMap.put(root.left, hdMap.get(root) - 1);
          results.computeIfAbsent(hdMap.get(root.left), k -> new ArrayList<>())
              .add(root.left.val);
          queue.add(root.left);
        }

        if (root.right != null) {
          hdMap.put(root.right, hdMap.get(root) + 1);
          results.computeIfAbsent(hdMap.get(root.right), k -> new ArrayList<>())
              .add(root.right.val);
          queue.add(root.right);
        }
      }
    }
  }
}
