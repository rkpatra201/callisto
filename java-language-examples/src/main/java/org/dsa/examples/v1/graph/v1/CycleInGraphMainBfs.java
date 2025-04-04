package org.dsa.examples.v1.graph.v1;

import org.dsa.examples.v1.graph.Node;
import utils.GraphUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CycleInGraphMainBfs {
  /**
   * 1 -- 2---4---|
   * |           |
   * ---3---5---8
   * |--6
   * <p>
   * node and parent mapping
   * 1,null
   * 2,1
   * 4,2
   * 8,4
   * 3,1
   * 6,3
   * 5,3
   * 8,5
   * <p>
   * adjacenyList:
   * <p>
   * 1: 2,3
   * 2: 1, 4
   * 3: 1,5,6
   * 4: 2, 8
   * 5: 3, 8
   * <p>
   * Ex: when node 4 is dequeued
   * we found its parent is 2.
   * 4 has edges: 2, 8
   * So we should not go towards parent node 2.
   * But we will visit 8 who is not parent of 4 and mark 8 as visited.
   * <p>
   * When node 5 is dequeued
   * we found its parent is 3
   * 5 has edges: 3, 8
   * so we should not go towards parent node 2
   * But we will visit 8 who is not parent of 5. But we see 8 is already visited. So edge 8 is cycle.
   *
   * @param args
   */
  public static void main(String[] args) {
    String[][] edges = {
        {"1", "2"},
        {"1", "3"},
        {"2", "4"},
        {"3", "5"},
        {"3", "6"},
        {"4", "8"},
        {"5", "8"},
        // another component below
        {"7", "9"},
        {"7", "10"},
        {"9", "11"},
        {"10", "11"},
    };

    GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);
    GraphUtils.displayAdjacencyList(graph);
    // nodeName, parentName
    Map<String, String> parentTracker = new HashMap<>();

    Set<String> nodes = graph.getNodes();

    Set<String> visited = new HashSet<>();
    Queue<Node> queue = new LinkedList<>();

    boolean found = false;
    for (String node : nodes) {

      if (visited.contains(node)) {
        continue;
      }

      parentTracker.put(node, null);

      queue.add(graph.getNode(node));
      visited.add(node);
      found = false;
      // as the element is added to queue,
      // bfs will explore all nodes in component of graph
      // when next iteration comes, it checks a node is visited or not,
      // so it will find a node of a new component which is not visited

      /**
       * Example:
       *
       * 1,2,3,4,5 and 7,8,9 are two components of a graph.
       *
       * When node with value 1 is added to the queue, its parent will be set as null.(because this is first node not visited in the component c1)
       * then the bfs explores all other nodes.
       * so 1,2,3,4,5 all are marked as visited.
       * Hence 2,3,4,5 will not be processed again and treated as continue in this loop.
       *
       * When the loop encounters 7 and it is not visited yet, and its parent will be null (because this is first node not visited in the component c2)
       * it will be added to queue, as a result bfs will explore other nodes in its component.
       */


      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {

          Node current = queue.poll();

          String parentName = parentTracker.get(current.getName());

          for (Node neighbour : current.getNeighbours()) {

            // current nodes neighbours contain its parent also.
            // ex: 1,2,3 For node 2 edges are [1,3]
            // we should not visit 1 as it is parent of 2.
            // so visit 3 and mark it as visited
            // but what if 3 is already visited by someone, then 3 is forming cycle.


            // we should be visiting this neighbour who is not parent, but it is already visited by someone else
            // so it is a cycle
            if (!found && !neighbour.getName().equals(parentName) && visited.contains(neighbour.getName())) {
              System.out.println("cycle: " + neighbour.getName());
              found = true;
            }

            if (neighbour.getName().equals(parentName)) {
              continue;
            }
            if (visited.contains(neighbour.getName())) {
              continue;
            }

            queue.add(neighbour);
            visited.add(neighbour.getName());
            parentTracker.put(neighbour.getName(), current.getName());
          }
        }
      }
    }
  }
}
