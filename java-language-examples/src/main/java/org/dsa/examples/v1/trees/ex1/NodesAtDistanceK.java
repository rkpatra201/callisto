package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistanceK {

  public static void main(String[] args) {
    TreeNode root = MakeTree.create(new Integer[][]{
        {1},
        {2, 3},
        {4, 5, 6, 7},
        {8, 9, 10, 11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}
    });
    TreeNode node = root;
    List<TreeNode> paths = new ArrayList<>();
    traverse(node, paths, 10);
    System.out.println(paths);
  }

  private static boolean traverse(TreeNode node, List<TreeNode> paths, int target){
    if(node == null){
      return false;
    }
    paths.add(node);
    if(node.data == target){
      return true;
    }
    boolean flag = traverse(node.left, paths, target) || traverse(node.right,paths, target);
    if(!flag){
      paths.remove(paths.size()-1);
    }
    return flag;
  }
}
