package org.dsa.examples.v1.graph.v1.cycle;

import org.dsa.examples.v1.graph.Node;
import utils.GraphUtils;

import java.util.HashSet;
import java.util.Set;

public class CycleInGraphMainDfs {

    public static void main(String[] args) {
        String[][] edges = {
                {"1", "2"},
                {"2", "3"},
                {"3", "4"},
                {"4", "5"},
                {"5", "6"},
                {"3", "6"},
                // another component below
                {"7", "9"},
                {"7", "10"},
                {"9", "11"},
                {"10", "11"},
        };

        GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);
        GraphUtils.displayAdjacencyList(graph);

        if (hasCycle(graph)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }

    public static boolean hasCycle(GraphUtils.Graph graph) {
        Set<String> visited = new HashSet<>();
        for (String nodeName : graph.getNodes()) {
            if (!visited.contains(nodeName)) {
                if (hasCycleRecursive(graph, nodeName, visited, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCycleRecursive(GraphUtils.Graph graph, String currentNodeName, Set<String> visited, String parentNodeName) {
        visited.add(currentNodeName);
        Node currentNode = graph.getNode(currentNodeName);

        for (Node neighbor : currentNode.getNeighbours()) {
            String neighborName = neighbor.getName();
            if (!visited.contains(neighborName)) {
                if (hasCycleRecursive(graph, neighborName, visited, currentNodeName)) {
                    return true;
                }
            } else if (parentNodeName != null && !neighborName.equals(parentNodeName)) {
                // If the neighbor is visited and is not the parent, we have a cycle.
                return true;
            }
        }
        return false;
    }
}