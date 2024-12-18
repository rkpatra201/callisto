package org.dsa.examples.trees.traversal;

import org.dsa.examples.trees.traversal.dfs.PreOrderTraversal_Iterative;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PreOrderTraversal_IterativeTest {

  @Test
  public void traverse() {
    List<Integer> list = new PreOrderTraversal_Iterative().traverse(TreeUtils.getTree());
    List<Integer> expectedList1 = Arrays.asList(40, 20, 10, 30, 60, 50, 80);
    System.out.println(list);
    Assert.assertEquals(list,expectedList1);
  }
}