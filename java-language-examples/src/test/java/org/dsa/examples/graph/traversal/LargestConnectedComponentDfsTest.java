package org.dsa.examples.graph.traversal;

import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;


public class LargestConnectedComponentDfsTest {

  @Test
  public void solution() {
    String[][] edges = {
        {"1","2"},
        {"3","4"},
        {"3","5"},
        {"3","6"},
        {"11","7"},
        {"11","8"},
        {"9"}
    };
    GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);
    LargestConnectedComponentDfs componentDfs = new LargestConnectedComponentDfs();
    int count =componentDfs.solution(graph);
    Assert.assertEquals(4, count);
  }
}