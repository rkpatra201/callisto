package org.dsa.examples.trees.traversal;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TraversalUtilsTest {

  @Test
  public void zig_zag_order_traverse() {
    List<List<Integer>> list = new TraversalUtils().zig_zag_order_traverse(TreeUtils.getTree());
    System.out.println(list);
  }

  @Test
  public void left_view_traverse() {
    List<Integer> list = new TraversalUtils().left_view_traverse(TreeUtils.getTree());
    List<Integer> list1 = Arrays.asList(40,20,10);
    Assert.assertEquals(list,list1);
  }

  @Test
  public void right_view_traverse() {
    List<Integer> list = new TraversalUtils().right_view_traverse(TreeUtils.getTree());
    List<Integer> list1 = Arrays.asList(40,60,80);
    Assert.assertEquals(list,list1);
  }
}