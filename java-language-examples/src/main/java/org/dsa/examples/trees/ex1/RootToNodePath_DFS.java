package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath_DFS {

  public static List<String> solution(TreeNode treeNode, int searchValue) {
    List<String> path = new ArrayList<>();
    traverse(treeNode, searchValue, path);
    return path;
  }

  private static boolean traverse(TreeNode node, int searchValue, List<String> path) {
    if (node == null) {
      return false;
    }

    path.add(String.valueOf(node.data));

    if (node.data == searchValue) {
      return true;
    }

    boolean flag =
        traverse(node.left, searchValue, path) ||
            traverse(node.right, searchValue, path);
    if (!flag) {
      path.remove(path.size() - 1);
    }
    return flag;
  }
}

