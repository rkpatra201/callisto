package org.dsa.examples.v1.graph.traversal;

import org.dsa.examples.v1.graph.Node;
import org.dsa.examples.v1.graph.traversal.HasPathDfs;
import org.junit.Assert;
import org.junit.Test;

public class HasPathDfsTest {

  /**
   * a ---> b
   * |     |
   * |     |
   * c<----d
   * |
   * |
   * e--->f
   *
   * @return
   */
  @Test
  public void solution() {
    Node node1 = new Node("a");
    Node node2 = new Node("b");
    Node node3 = new Node("c");
    Node node4 = new Node("d");
    Node node5 = new Node("e");
    Node node6 = new Node("f");

    node1.addNeighbour(node2).addNeighbour(node3);
    node2.addNeighbour(node4);
    node4.addNeighbour(node3);
    node3.addNeighbour(node5);
    node5.addNeighbour(node6);

    HasPathDfs hasPathDfs = new HasPathDfs();
    boolean flag = hasPathDfs.solution(node2, node1); // path doesn't exist
    Assert.assertEquals(flag, false);

    flag = hasPathDfs.solution(node2, node5); // path exist
    Assert.assertEquals(flag, true);
  }
}