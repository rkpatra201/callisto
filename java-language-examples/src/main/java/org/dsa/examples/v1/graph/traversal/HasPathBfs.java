package org.dsa.examples.v1.graph.traversal;

import org.dsa.examples.v1.graph.Node;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathBfs {


  public boolean solution(Node source, Node dest) {
    if (source.getName().equals(dest.getName())) {
      return true;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      if (current.getName().equals(dest.getName())) {
        return true;
      }
      current.getNeighbours().forEach(queue::add);
    }
    return false;
  }
}
