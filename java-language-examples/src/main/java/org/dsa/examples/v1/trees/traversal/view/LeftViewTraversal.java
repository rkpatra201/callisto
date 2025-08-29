package org.dsa.examples.v1.trees.traversal.view;

import org.dsa.examples.v1.trees.traversal.TraversalUtils;
import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.List;

public class LeftViewTraversal {
  public List<Integer> traverse(TreeNode treeNode){
    return new TraversalUtils().left_view_traverse(treeNode);
  }
}
