package org.dsa.examples.v1.graph.traversal;

import org.dsa.examples.v1.graph.Node;
import org.dsa.examples.v1.graph.traversal.DepthFirstTraversal;
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