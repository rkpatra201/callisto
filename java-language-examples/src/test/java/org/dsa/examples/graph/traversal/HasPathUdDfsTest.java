package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

public class HasPathUdDfsTest {

  @Test
  public void solution() {
    String[][] edges = {
        {"a","b"},
        {"a","c"},
        {"b","c"},
        {"b","d"},
        {"b","e"},
        {"e","c"},
    };

    GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);
    Node node1 = graph.getNode("a");
    Node node2 = graph.getNode("d");

    HasPathUdDfs hasPathUdDfs = new HasPathUdDfs();
    boolean status = hasPathUdDfs.solution(node1, node2);
    Assert.assertTrue(status);
  }

}