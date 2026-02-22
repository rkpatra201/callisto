package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.LevelOrderTraversal_Queue;
import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MakeTree {
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getThreadGroup().getParent());
    TreeNode root = create(new Integer[][]{
        {1},
        {2, 3},
        {4, 5, 6, 7},
        {8, 9, 10, 11, 12, 13, 14, 15}
    });

    List<Integer> result = new LevelOrderTraversal_Queue().traverse(root);
    System.out.println(result);
    TreeNode lca = Lca_DFS.solution(root, new TreeNode(5), new TreeNode(100));
    System.out.println(lca);
  }

  public static TreeNode create(Integer[][] inputs) {
    TreeNode root = new TreeNode(-1);
    List<TreeNode> currentLevel = new ArrayList<>();
    int level = 1;

    root.data = inputs[0][0];
    currentLevel.add(root);
    List<TreeNode> prevLevel = new ArrayList<>(currentLevel);
    currentLevel.clear();
    for (Integer[] row : inputs) {
      if (level == 1) {
        level++;
        continue;
      }
      int index = 0;
      for (TreeNode item : prevLevel) {
        Integer leftValue = row[index++];
        Integer rightValue = row[index++];
        item.left = new TreeNode(leftValue);
        item.right = new TreeNode(rightValue);
        currentLevel.add(item.left);
        currentLevel.add(item.right);
      }
      level++;
      prevLevel.clear();
      prevLevel = new ArrayList<>(currentLevel);
      currentLevel.clear();
    }
    return root;
  }
}
