package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.ex1.RootToNodePath_DFS;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

import java.util.List;

public class RootToNodePathRecursionTest {

  @Test
  public void solution() {
    List<String> path = RootToNodePath_DFS.solution(TreeUtils.getTree(), 60 );
    System.out.println(path);
  }
}