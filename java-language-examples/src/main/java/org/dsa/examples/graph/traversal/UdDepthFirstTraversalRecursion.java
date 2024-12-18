package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * undirected path graph
 */
public class UdDepthFirstTraversalRecursion {

  private static void recursive(Set<String> nodeNames, Node node) {
    if (nodeNames.contains(node.getName())) { // this will help avoid visiting same node
      return;
    }
    nodeNames.add(node.getName());
    for (Node edge : node.getNeighbours()) {
      recursive(nodeNames, edge);
    }
  }

  public Set<String> solution(Node node) {
    Set<String> nodeNames = new HashSet<>();
    recursive(nodeNames, node);
    return nodeNames;
  }
}
