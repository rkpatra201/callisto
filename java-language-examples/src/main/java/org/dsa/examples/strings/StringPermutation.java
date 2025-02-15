package org.dsa.examples.strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public List<String> solution(String input){
        List<String> result = new ArrayList<>();
        recursive(result, input, "");
        return result;
    }

    private void recursive(List<String> result, String input, String output){
      if(input.isEmpty()){
        result.add(output);
        return;
      }

      for(int i = 0; i < input.length();  i++){
        String firstPart = input.substring(0, i);
        String secondPart = input.substring(i);
        recursive(result, firstPart, output+secondPart);
      }
    }
}
