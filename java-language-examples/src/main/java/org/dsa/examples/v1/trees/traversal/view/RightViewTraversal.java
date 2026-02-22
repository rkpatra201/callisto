package org.dsa.examples.v1.trees.traversal.view;

import org.dsa.examples.v1.trees.traversal.TraversalUtils;
import org.dsa.examples.v1.trees.traversal.TreeNode;

import java.util.List;

public class RightViewTraversal {
  public List<Integer> traverse(TreeNode treeNode){
    return new TraversalUtils().right_view_traverse(treeNode);
  }
}
