package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/1569971711/
public class PhoneNumber {
  public List<String> solution(String digits) {
    String[] numStrs = {"0",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",
        "+"
    };

    List<String> solutions = new ArrayList<>();

    List<String> options = digits.chars().mapToObj(key-> (char)key).map(key->
            Character.digit(key, 10)
        ).map(key -> numStrs[key])
        .toList();

    System.out.println(options);
    return recursive(options, 0, "");
  }


  private List<String> recursive(List<String> options, int index, String tempStr) {
    if (index == options.size()) {
      System.out.println(tempStr);
      if(tempStr.length()==0){
        return new ArrayList<>();
      }
      return new ArrayList<>(List.of(tempStr));
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < options.get(index).length(); i++) {
      char current = options.get(index).charAt(i);
      result.addAll(recursive(options, index + 1, tempStr + current));
    }

//    System.out.println(result);
    return result;
  }
}
