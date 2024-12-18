package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import utils.GraphUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortedDistanceBetween2NodesBfs {

  public int solution(GraphUtils.Graph graph, String sourceNodeName, String targetNodeName) {
    return findDistance(graph, sourceNodeName, targetNodeName);
  }

  private int findDistance(GraphUtils.Graph graph, String source, String target) {


    Set<String> visitedNodes = new HashSet<>();

    Queue<DistanceNode> distanceNodeQueue = new LinkedList<>();

    DistanceNode distanceNode = new DistanceNode();
    distanceNode.source = source;
    distanceNode.name = source;
    distanceNode.distance = 0;

    distanceNodeQueue.add(distanceNode);

    int shortestDistance = 0;
    while (true) {
      if (distanceNodeQueue.isEmpty()) {
        break;
      }

      DistanceNode currentNode = distanceNodeQueue.poll();
      if (visitedNodes.contains(currentNode.name)) {
        continue;
      }

      if (target.equals(currentNode.name)) {
        shortestDistance = currentNode.distance;
        break;
      }

      visitedNodes.add(currentNode.name);
      for (Node node : graph.getNode(currentNode.name).getNeighbours()) {
        DistanceNode currentDistanceNode = new DistanceNode();
        currentDistanceNode.source = source;
        currentDistanceNode.name = node.getName();
        currentDistanceNode.distance = currentNode.distance + 1;
        distanceNodeQueue.add(currentDistanceNode);
      }

    }
    return shortestDistance;
  }

  private static class DistanceNode {
    String source;
    String name;
    int distance;
  }
}
