package org.dsa.examples.graph.traversal;

import org.junit.Assert;
import org.junit.Test;
import utils.GraphUtils;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ConnectedComponentDfsTest {

  @Test
  public void solution() {
    String[][] edges = {
        {"1","2"},
        {"3","4"},
        {"3","5"},
        {"3","6"},
        {"3","7"},
        {"3","8"},
        {"9"}
    };
    GraphUtils.Graph graph = GraphUtils.createUndirectedPathGraph(edges);
    ConnectedComponentDfs componentDfs = new ConnectedComponentDfs();
    int count =componentDfs.solution(graph);
    Assert.assertEquals(3, count);
  }

  @Test
  public void soln(){
    String[][] arr ={
        {"0","0","0","0"},
        {"0","b","0","0"},
        {"c","a","d","0"},
        {"0","e","0","0"},
        {"0","0","0","0"},
        {"0","e1","e2","0"},
        {"0","0","e3","e4"},
    };

    Set<String> visited = new HashSet<>();
    for (int i =0; i < 7; i++){
      for(int j=0; j < 4; j++){
        explore(arr, i,j,visited);
      }
    }

    System.out.println(visited);


  }


  private void explore(String[][] arr, int i, int j, Set<String> visited){
    if(!(i>=0 && i < 7 && j> 0 && j < 4)){
      return;
    }
    String current = arr[i][j];
    if(current.equals("0")){
      return;
    }
    if(visited.contains(current)){
      return;
    }
    System.out.println(i+ "" + j + ""+ current);
    visited.add(current);
    explore(arr, i, j+1, visited);
    explore(arr, i, j-1, visited);
    explore(arr, i+1, j, visited);
    explore(arr, i-1, j, visited);
  }
}