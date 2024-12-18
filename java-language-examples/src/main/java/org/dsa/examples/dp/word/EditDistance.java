package org.dsa.examples.dp.word;

public class EditDistance {

  public int solution(String x, String y){
    return solution(x, y, x.length(), y.length());
  }

  private int solution(String x, String y, int m, int n){
    if(n == 0){
      return m;
    }
    if(m == 0){
      return n;
    }
    if(x.charAt(m-1) == y.charAt(n-1)){
      return solution(x, y, m-1, n-1);
    }

    int deleteFromSecondString = solution(x, y, m, n-1 );
    int deleteFromFirstString = solution(x, y, m-1, n);
    int replaceInBothString = solution(x, y, m-1,n-1);
    int minValue = Math.min(deleteFromFirstString, deleteFromSecondString);
    minValue = Math.min(minValue, replaceInBothString);
    return 1 + minValue; // adding 1 because one success operation happening
  }
}
