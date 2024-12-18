package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * has path un-directed graph
 */
public class HasPathUdBfs {

  public boolean solution(Node source, Node dest) {
    if (source.getName().equals(dest.getName())) {
      return true;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      queue.addAll(current.getNeighbours());
      if (current.getName().equals(dest.getName())) {
        return true;
      }
    }
    return false;
  }
}
