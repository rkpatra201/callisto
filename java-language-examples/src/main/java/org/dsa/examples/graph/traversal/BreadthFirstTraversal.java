package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversal {

  public List<String> solution(Node node) {
    List<String> nodes = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    if (node != null) {
      queue.offer(node);
    }
    while (!queue.isEmpty()) {
      Node front = queue.poll();
      nodes.add(front.getName());
      if (node.getNeighbours().isEmpty()) {
        continue;
      }
      front.getNeighbours().forEach(queue::offer);
    }
    System.out.println(nodes);
    return nodes;
  }
}
