package org.dsa.examples.v1.recursion;

public class BinaryStringWithoutConsecutiveOnes {

  public static void main(String[] args) {
    solution(new StringBuffer(), 4, 0, 0);
  }
  public static void solution(StringBuffer result, int size, int lastNum, int countOnes){
    if(result.length() == size){
      System.out.println(result);
      return;

    }

    if(lastNum == 1 && countOnes == 1){
       result = new StringBuffer(result);
       result.append("0");
       solution(result,size,0, 0);
    }
    else{
      StringBuffer tempResult = new StringBuffer(result);
      result = new StringBuffer(tempResult);
      result.append("0");
      solution(result,size,0, 0);

      result = new StringBuffer(tempResult);
      result.append("1");
      solution(result,size,1, countOnes+1);
    }

  }
}
