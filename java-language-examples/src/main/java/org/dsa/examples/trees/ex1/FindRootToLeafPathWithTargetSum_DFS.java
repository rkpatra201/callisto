package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindRootToLeafPathWithTargetSum_DFS {

  public static List<Integer> solution(TreeNode root, int targetSum) {
    traverse2(root, targetSum);
    return paths;
  }

  private static List<Integer> paths = new ArrayList<>();

  private static boolean traverse2(TreeNode root, int targetSum) {
    if (root == null)
      return false;
    paths.add(root.data);
    if (root.left == null && root.right == null && root.data == targetSum) {
      System.out.println(paths);
      return true;
    }
    int remainSum = targetSum - root.data;
    boolean flag = traverse2(root.left, remainSum) ||
        traverse2(root.right, remainSum);
    if (!flag) {
      paths.remove(paths.size() - 1);
    }
    return flag;
  }

}
