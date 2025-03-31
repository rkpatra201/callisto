package org.dsa.examples.blind75.w2;

// https://leetcode.com/problems/palindromic-substrings/submissions/1584722988/
public class _07CountPalinSubStrings {
  public int countSubstrings(String s) {
    int tc = 0;
    for(int i =0; i < s.length();i++){
      int left = palinCount(s, i, i); // odd indexed
      int right = palinCount(s, i, i+1); // even indexed
      tc += left + right;
    }
    return tc;
  }


  public int palinCount(String s, int i, int j){ // expand in both directions and count untill match happens
    int count =0;
    while(i >= 0 && j <= s.length() - 1){ // i and j both inclusive and valid index
      if(s.charAt(i) == s.charAt(j)){
        count = count + 1;
      }
      else{
        break;
      }
      i--;
      j++;
    }
    return count;
  }
}
