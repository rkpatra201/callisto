package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import utils.GraphUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * un-directed graph connected component
 * <p>
 * 1-2
 * <p>
 * 3-4-5
 * |
 * 6
 * <p>
 * 7-8
 * <p>
 * Here we have 3 connected components in the graph
 */
public class ConnectedComponentDfs {

  public int solution(GraphUtils.Graph graph) {
    int count = 0;
    Set<String> nodes = graph.getNodes();
    Set<String> visitedNodes = new HashSet<>();
    for (String nodeName : nodes) {
      boolean flag = traverse(graph.getNode(nodeName), visitedNodes);
      if (flag)
        count++;
    }
    return count;
  }

  private boolean traverse(Node node, Set<String> visitedNodes) {
    if (visitedNodes.contains(node.getName())) { // already visited node
      return false;
    }
    visitedNodes.add(node.getName());
    for (Node current : node.getNeighbours()) { // explore neighbours
      traverse(current, visitedNodes);
    }
    return true; // after neighbour explore return true
  }
}
