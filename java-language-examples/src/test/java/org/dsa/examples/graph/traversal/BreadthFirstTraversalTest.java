package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BreadthFirstTraversalTest {

  @Test
  public void solution() {
    Node node = GraphUtils.getGraph();
    List<String> expected = Arrays.asList("a","b","c","d","e","f");
    BreadthFirstTraversal breadthFirstTraversal = new BreadthFirstTraversal();
    List<String> actual =breadthFirstTraversal.solution(node);
    Assert.assertEquals(expected,actual);
  }

}