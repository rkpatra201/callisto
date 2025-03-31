package org.dsa.examples.blind75.w1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/group-anagrams/submissions/1583132085/
public class _10GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> group = new HashMap<>();
    for(String input: strs){
      String key = getAnagramKey(input);
      List<String> existingResult = group.getOrDefault(key, new ArrayList<>());
      existingResult.add(input);
      group.putIfAbsent(key, existingResult);
    }

    return new ArrayList<>(group.values());
  }

  private String getAnagramKey(String input){
    if(input.isEmpty()){
      return "";
    }
    int[] freq = new int[256];
    for(int i=0; i< input.length();i++){
      freq[input.charAt(i)] = freq[input.charAt(i)] + 1;
    }
    StringBuilder key = new StringBuilder();
    for(int i=0;i<freq.length;i++){
      int v = freq[i];
      key.append(i+"#"+v);
    }
    return key.toString();
  }
}
