package org.dsa.examples.v1.graph.traversal;

import org.dsa.examples.v1.graph.Node;
import org.dsa.examples.v1.graph.traversal.HasPathUdBfs;
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