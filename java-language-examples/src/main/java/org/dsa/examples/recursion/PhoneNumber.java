package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumber {
  public List<List<Character>> solution(List<Integer> values)
  {
    String[] numStrs = {"0",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqr",
        "tuv",
        "wxz",
        "+"
    };

    List<Character> enteredValues = new ArrayList<>();
    for(int value: values){
      String valueStr = numStrs[value];
      List<Character> charValues = valueStr.chars()
          .mapToObj(e-> (char)e)
              .collect(Collectors.toList());
      enteredValues.addAll(charValues);
    }

    List<List<Character>> solutions = new ArrayList<>();
    numToChars(enteredValues,0, new ArrayList<>(), solutions, values.size());
    System.out.println(solutions);
    return solutions;
  }

  private void numToChars(List<Character> charValues,
                          int index,
                          List<Character> current,
                          List<List<Character>> solutions,
                          int setSize){
    if(index == charValues.size()){
      if(setSize == current.size()){
        solutions.add(new ArrayList<>(current));
      }
      return;
    }

    List<Character> includes = new ArrayList<>(current);
    includes.add(charValues.get(index));
    numToChars(charValues, index + 1, includes, solutions, setSize);

    List<Character> excludes = new ArrayList<>(current);
    numToChars(charValues, index + 1, excludes, solutions, setSize);
  }
}
