package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UdBreadthFirstTraversalTest {

  @Test
  public void solution() {

    String[][] edges = {
        {"a", "b"},
        {"a", "c"},
        {"b", "d"},
        {"b", "e"},
        {"e", "c"},
    };

    Node node = GraphUtils.uniDirectedGraph(edges);
    GraphUtils.displayAdjacencyList(node);

    UdBreadthFirstTraversal traversal = new UdBreadthFirstTraversal();
    Set<String> actual = traversal.solution(node);
    Set<String> expected = Stream.of("a", "b", "c", "d", "e").collect(Collectors.toSet());
    Assert.assertEquals(actual, expected);

  }
}