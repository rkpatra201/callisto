package utils;

import org.dsa.examples.graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphUtils {

  /**
   * a ---> b
   * |     |
   * |     |
   * c     d
   * |
   * |
   * e--->f
   *
   * @return
   */

  public static Node getGraph() {
    Node node1 = new Node("a");
    Node node2 = new Node("b");
    Node node3 = new Node("c");
    Node node4 = new Node("d");
    Node node5 = new Node("e");
    Node node6 = new Node("f");

    node1.addNeighbour(node2).addNeighbour(node3);
    node2.addNeighbour(node4);
    node3.addNeighbour(node5);
    node5.addNeighbour(node6);
    return node1;
  }

  public static void displayAdjacencyList(Node node) {
    Queue<Node> queue = new LinkedList<>();
    Set<String> names = new HashSet<>();
    queue.add(node);
    names.add(node.getName());
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      System.out.println(current.asString());
      current.getNeighbours().forEach(e -> {
        if (!names.contains(e.getName())) {
          queue.add(e);
          names.add(e.getName());
        }
      });
    }
  }

  public static Node uniDirectedGraph(String[][] edges) {
    for (String[] edge : edges) {
      String v1 = edge[0];
      String v2 = edge[1];
      Graph.getInstance().addMapping(v1, v2);
    }
    return Graph.getInstance().getRootNode();
  }

  public static Graph createUndirectedPathGraph(String[][] edges) {
    Graph graph = new Graph();
    for (String[] edge : edges) {
      String v1 = null;
      String v2 = null;
      if (edge.length >= 1)
        v1 = edge[0];
      if (edge.length >= 2)
        v2 = edge[1];

      graph.addMapping(v1, v2);
    }
    return graph;
  }

  public static class Graph {
    private static Graph INSTANCE = new Graph();
    private Map<String, Node> nodeMapping = new HashMap<>();
    private Node rootNode = null;

    public static Graph getInstance() {
      return INSTANCE;
    }

    public void addMapping(String name1, String name2) {
      if (name1 != null && !nodeMapping.containsKey(name1)) {
        Node node = new Node(name1);
        if (rootNode == null) {
          rootNode = node;
        }
        nodeMapping.put(name1, node);
      }
      if (name2 != null && !nodeMapping.containsKey(name2)) {
        Node node = new Node(name2);
        nodeMapping.put(name2, node);
      }
      if(name1!=null && name2!=null) {
        nodeMapping.get(name1).addNeighbour(nodeMapping.get(name2));
        nodeMapping.get(name2).addNeighbour(nodeMapping.get(name1));
      }
    }

    public Node getRootNode() {
      return rootNode;
    }

    public Node getNode(String name) {
      return nodeMapping.get(name);
    }

    public Set<String> getNodes() {
      return nodeMapping.keySet();
    }
  }
}
