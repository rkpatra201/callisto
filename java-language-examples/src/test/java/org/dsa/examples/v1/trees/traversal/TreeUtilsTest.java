package org.dsa.examples.v1.trees.traversal;

import org.dsa.examples.v1.trees.traversal.TreeNode;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class TreeUtilsTest {

  @Test
  public void height() {
    TreeNode treeNode = TreeUtils.getTree();
    int h = new TreeUtils().height(treeNode);
    System.out.println(h);
  }
}