package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstTraversalRecursion {

  public List<String> solution(Node node) {
    List<String> output = new ArrayList<>();
    recursive(node, output);
    return output;
  }

  private void recursive(Node node, List<String> output) {
    if (node == null) {
      return;
    }
    output.add(node.getName());
    List<Node> edges = node.getNeighbours();
    for (Node edge : edges) {
      recursive(edge, output);
    }
  }
}
