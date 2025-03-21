package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TraversalUtils;
import org.dsa.examples.trees.traversal.TreeNode;
import org.dsa.examples.trees.traversal.dfs.InOrderTraversal_Recursion;
import org.dsa.examples.trees.traversal.dfs.PreOrderTraversal_Recursion;

import java.util.List;

public class SortedListToBst {

  public static void main(String[] args) {
    List<Integer> result = List.of(1, 2, 3, 4, 5, 6, 7);

    TreeNode node = traverse(result);

    System.out.println(result);
    result = new InOrderTraversal_Recursion().traverse(node);
    System.out.println(result);
  }

  private static TreeNode traverse(List<Integer> inputs) {

    if(inputs.isEmpty()){
      return null;
    }

    int m = inputs.size() / 2;

    TreeNode node = new TreeNode(inputs.get(m));
    node.left = traverse(inputs.subList(0, m));
    node.right = traverse(inputs.subList(m + 1, inputs.size()));

    return node;
  }
}
