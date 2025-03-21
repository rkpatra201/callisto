package org.dsa.examples.dp.str.str;

// https://leetcode.com/problems/palindromic-substrings/submissions/1576409979/
public class CountPalinSubStrings {

  public int countSubstrings(String s) {
    int tc = 0;
    for(int i =0; i < s.length();i++){
      int oddLen = palinCount(s, i, i);
      int evenLen = palinCount(s, i, i+1);
      tc += oddLen + evenLen;
    }
    return tc;
  }


  public int palinCount(String s, int i, int j){
    int count =0;
    while(i >= 0 && j <= s.length() - 1){
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
