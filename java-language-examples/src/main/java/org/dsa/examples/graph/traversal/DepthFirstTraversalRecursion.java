package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstTraversalRecursion {

  public List<String> solution(Node node) {
    List<String> traversedNodeNames = new ArrayList<>();
    recursive(node, traversedNodeNames);
    return traversedNodeNames;
  }

  private void recursive(Node node, List<String> traversalNames) {
    if (node == null) {
      return;
    }
    traversalNames.add(node.getName());
    List<Node> edges = node.getNeighbours();
    for (Node edge : edges) {
      recursive(edge, traversalNames);
    }
  }
}
