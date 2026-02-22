package org.dsa.examples.v1.graph.traversal;

import org.dsa.examples.v1.graph.Node;
import org.dsa.examples.v1.graph.traversal.DepthFirstTraversalRecursion;
import org.junit.Test;
import utils.GraphUtils;

import java.util.List;


public class DepthFirstTraversalRecursionTest {

  @Test
  public void solution() {
    Node node = GraphUtils.getGraph();
    DepthFirstTraversalRecursion recursion = new DepthFirstTraversalRecursion();
    List<String> actual =recursion.solution(node);
    System.out.println(actual);
  }
}