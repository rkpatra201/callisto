package org.dsa.examples.graph.traversal;

import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

import static org.junit.Assert.*;

public class ShortedDistanceBetween2NodesBfsTest {

  @Test
  public void solution() {

    String[][] edges = {
        {"A", "B"},
        {"A", "D"},
        {"D", "E"},
        {"B", "C"},
        {"C", "H"},
        {"C", "F"},
        {"H", "K"},
        {"K", "F"},
        {"F", "K"},
        {"F", "G"},
    };
    GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);

    ShortedDistanceBetween2NodesBfs bfs = new ShortedDistanceBetween2NodesBfs();
    int result = bfs.solution(graph, "A", "G");
    Assert.assertEquals(4, result);
  }
}