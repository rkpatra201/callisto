package org.dsa.examples.lc.sw;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1598813719/
public class _1456MaxVowelsInASubStrOfLengthK {

  public static void main(String[] args) {
    int k = 3;
    String input = "leetcode";
    int result = new _1456MaxVowelsInASubStrOfLengthK().maxVowels(input, k);
    System.out.println(result);
  }
  public int maxVowels(String s, int k) {
    int maxVowelCount = 0;
    int i = 0;
    while(i < s.length() && i < k){
      char c = s.charAt(i);
      if(isVowel(c)){
        maxVowelCount++;
      }
      i++;
    }

    int prev = 0;
    int windowVowelCount = maxVowelCount;
    while(i < s.length()){
      char prevChar = s.charAt(prev);
      int dec = 0;
      int inc = 0;
      if(isVowel(prevChar)){
        dec--;
      }
      char currChar = s.charAt(i);
      if(isVowel(currChar)){
        inc++;
      }
      int change = dec + inc;
      windowVowelCount = windowVowelCount + change;
      maxVowelCount = Math.max(maxVowelCount, windowVowelCount);
      prev++;
      i++;
    }
    return maxVowelCount;
  }

  private boolean isVowel(char c){
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
      return true;
    }
    return false;
  }
}
