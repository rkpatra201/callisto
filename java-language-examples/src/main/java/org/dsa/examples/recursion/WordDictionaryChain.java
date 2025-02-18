package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/word-ladder/description/
public class WordDictionaryChain {

  private static List<String> path = new ArrayList<>();

  public List<String> solution(String a, String b, String[] options){

    if(a.equals(b)){
      return new ArrayList<String>(){{

      }};
    }

    for(String option: options){
      if(a.length()!=b.length()){
        continue;
      }
      int diffCount = 0;
      int[] charTracker = new int[256];
      for(int i=0; i < option.length(); i++){
           charTracker[a.charAt(i)]++;
           charTracker[option.charAt(i)]--;
      }
      for(int i : charTracker){
        if(i !=0){
          diffCount++;
        }
      }
      if(diffCount == 2){
        List<String> optionList = Arrays.stream(options).filter(e-> !e.equals(option))
            .collect(Collectors.toList());
        List<String> result = solution(option, b, optionList.toArray(new String[0]));
        if(result != null){
          result.add(0, option);
          return result;
        }
      }
    }

    return null;


  }
}
