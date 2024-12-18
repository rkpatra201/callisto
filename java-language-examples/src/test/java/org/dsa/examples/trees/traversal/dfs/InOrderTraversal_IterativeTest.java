package org.dsa.examples.trees.traversal.dfs;

import org.dsa.examples.trees.traversal.TreeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InOrderTraversal_IterativeTest {

  @Test
  public void traverse() {
    List<Integer> list = new InOrderTraversal_Iterative().traverse(TreeUtils.getTree());
    List<Integer> expectedList = Arrays.asList(10, 20, 30, 40, 50, 60, 80);
    Assert.assertEquals(list, expectedList);
    System.out.println(list);
  }
}