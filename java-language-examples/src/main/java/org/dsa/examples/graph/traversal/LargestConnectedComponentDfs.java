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
 * Here we have 3 connected components in the graph, and the largest component size = 4
 */
public class LargestConnectedComponentDfs {

  public int solution(GraphUtils.Graph graph) {
    Set<String> nodes = graph.getNodes();
    Set<String> visitedNodes = new HashSet<>();
    int max = 0;
    for (String nodeName : nodes) {
      if (visitedNodes.contains(nodeName)) {
        continue;
      }
      visitedNodes.clear();
      Node node = graph.getNode(nodeName);
      traverse(node, visitedNodes);
      System.out.println(visitedNodes);
      max = Math.max(visitedNodes.size(), max);
    }

    return max;
  }

  public void traverse(Node node, Set<String> visitedNodes) {
    if (visitedNodes.contains(node.getName())) {
      return;
    }
    visitedNodes.add(node.getName());
    for (Node neighbour : node.getNeighbours()) {
      traverse(neighbour, visitedNodes);
    }
  }
}
