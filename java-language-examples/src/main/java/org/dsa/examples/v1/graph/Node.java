package org.dsa.examples.v1.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node {

  String name;
  int weight;
  List<Node> neighbours;

  public Node(String name) {
    this(name, 0);
  }

  public Node(String name, int weight) {
    this.name = name;
    this.weight = weight;
    this.neighbours = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public List<Node> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<Node> neighbours) {
    this.neighbours = neighbours;
  }

  public Node addNeighbour(Node n) {
    if (n != null) {
      this.neighbours.add(n);
    }
    return this;
  }

  public String asString() {
    return this.name + " : " + neighbours.stream().map(e -> e.getName()).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return this.name + ":" + this.weight + ":" + neighbours.stream().map(e -> e.getName()).collect(Collectors.toList());
  }
}
