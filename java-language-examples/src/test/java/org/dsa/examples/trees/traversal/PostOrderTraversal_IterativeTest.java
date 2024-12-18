package org.dsa.examples.trees.traversal;

import org.dsa.examples.trees.traversal.dfs.PostOrderTraversal_Iterative;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PostOrderTraversal_IterativeTest {

  @Test
  public void traverse() {
    List<Integer> list = new PostOrderTraversal_Iterative().traverse(TreeUtils.getTree());
    List<Integer> expectedList = Arrays.asList(10, 30, 20, 50, 80, 60, 40);
    System.out.println(list);
    Assert.assertEquals(list, expectedList);
  }
}