package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

public class HasPathUdBfsTest {

  @Test
  public void solution() {
    String[][] edges = {
        {"a","b"},
        {"a","c"},
        {"b","d"},
        {"b","e"},
        {"e","c"},
    };

    GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);
    GraphUtils.displayAdjacencyList(graph.getRootNode());
    Node node1 = graph.getNode("a");
    Node node2 = graph.getNode("d");

    HasPathUdBfs hasPathUdDfs = new HasPathUdBfs();
    boolean status = hasPathUdDfs.solution(node1, node2);
    Assert.assertTrue(status);
  }
}