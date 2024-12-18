package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstTraversal {

  public List<String> solution(Node node) {
    List<String> traversedNodeNames = new ArrayList<>();

    Stack<Node> stack = new Stack<>();
    if (node != null) {
      stack.push(node);
    }
    while (!stack.isEmpty()) {
      Node top = stack.pop();
      traversedNodeNames.add(top.getName());
      if (top.getNeighbours().size() == 0) {
        continue;
      }
      top.getNeighbours().forEach(stack::push);
    }
    System.out.println(traversedNodeNames);
    return traversedNodeNames;
  }
}
