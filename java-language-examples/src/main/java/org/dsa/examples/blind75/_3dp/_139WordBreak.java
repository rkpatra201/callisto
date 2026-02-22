package org.dsa.examples.blind75._3dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/word-break/submissions/1576259874/
public class _139WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, new HashSet<>(wordDict));
  }

  private Map<String, Boolean> result = new HashMap<>();
  public boolean wordBreak(String s, Set<String> wordDict) {
    if(result.containsKey(s)){
      return result.get(s);
    }
    if (s.isEmpty()) {
      return true;
    }

    boolean flag = false;
    for (String word: wordDict) {
      if(!s.startsWith(word)){
        continue;
      }
      int startAt = s.indexOf(word);
      int endAt = startAt + word.length();
      String remainStr = s.substring(endAt);
      flag = wordBreak(remainStr, wordDict);
      result.put(remainStr, flag);
      if(flag){
        break;
      }
    }
    return flag;
  }
}
