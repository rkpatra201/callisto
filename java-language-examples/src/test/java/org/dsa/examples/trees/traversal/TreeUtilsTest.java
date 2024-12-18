package org.dsa.examples.trees.traversal;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeUtilsTest {

  @Test
  public void height() {
    TreeNode treeNode = TreeUtils.getTree();
    int h = new TreeUtils().height(treeNode);
    System.out.println(h);
  }
}