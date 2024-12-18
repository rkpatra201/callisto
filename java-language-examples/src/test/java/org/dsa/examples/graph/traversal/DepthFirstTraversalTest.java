package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

import java.util.Arrays;
import java.util.List;

public class DepthFirstTraversalTest {

  @Test
  public void solution() {
    Node node = GraphUtils.getGraph();
    List<String> expected = Arrays.asList("a", "c", "e", "f", "b", "d");
    DepthFirstTraversal depthFirstTraversal = new DepthFirstTraversal();
    List<String> actual =depthFirstTraversal.solution(node);
    Assert.assertEquals(expected, actual);
  }
}