package org.dsa.examples.graph.traversal;

import org.dsa.examples.graph.Node;
import org.junit.Assert;
import org.junit.Test;

public class HasPathBfsTest {

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

    HasPathBfs hasPathBfs = new HasPathBfs();
    boolean flag = hasPathBfs.solution(node2, node1); // path doesn't exist
    Assert.assertEquals(flag, false);

    flag = hasPathBfs.solution(node2, node6); // path exist
    Assert.assertEquals(flag, true);
  }
}