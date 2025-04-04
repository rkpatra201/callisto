package org.dsa.examples.v1.graph.v1;

import utils.GraphUtils;

public class CycleInDirectedGraphRecursive {
  public static void main(String[] args) {
    String[][] edges = {
        {"1", "2"},
        {"2", "3"},
        {"3", "1"},
    };
    GraphUtils.Graph graph = GraphUtils.createDirectedPathGraph(edges);
    GraphUtils.displayAdjacencyList(graph);
  }
}
