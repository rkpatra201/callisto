package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/word-break-ii/submissions/1576267709/
public class WordBreak2 {

  public List<String> solution(String s, List<String> wordDict) {

    return new WordBreak2().wordBreak(s, wordDict);

  }

  private List<String> solutions = new ArrayList<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    wordBreak(s, "", new HashSet<>(wordDict));
    return solutions;
  }

  public void wordBreak(String s, String result, Set<String> wordDict) {

    if (s.isEmpty()) {
      solutions.add(result);
      return;
    }

    for (String word : wordDict) {
      if (!s.startsWith(word)) {
        continue;
      }
      int startAt = s.indexOf(word);
      int endAt = startAt + word.length();
      String remainStr = s.substring(endAt);

      String newResult = result.isEmpty() ? word : result+" "+word;
      wordBreak(remainStr, newResult, wordDict);
    }
  }
}
