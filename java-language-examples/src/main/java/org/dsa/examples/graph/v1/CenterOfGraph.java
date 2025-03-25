package org.dsa.examples.graph.v1;

// https://leetcode.com/submissions/detail/1584395675/
public class CenterOfGraph {

  public int findCenter(int[][] edges) {

    //[1,2][2,3][4,2]
    // here 2 is the center as it is present int all edges

    int[] v1 = edges[0];
    int[] v2 = edges[1];

    // match with same index or match with alternate index
    if(v1[0]==v2[0] || v1[0]==v2[1]){
      return v1[0];
    }


    if(v2[1]==v1[1] || v2[0]==v1[1]){
      return v1[1];
    }

    return -1;

  }
}
