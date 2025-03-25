package org.dsa.examples.graph.v1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/word-ladder/submissions/1585531501/
public class WordLadder1 {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> words = new HashSet<>(wordList);
    if (!words.contains(endWord)) {
      return 0;
    }

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int levelCount = 1;  // Start from 1 because beginWord is included in the transformation

    while (!queue.isEmpty()) {
      int size = queue.size(); // Process all words in the current level
      for (int i = 0; i < size; i++) {
        String word = queue.poll();

        if (word.equals(endWord)) {
          return levelCount;
        }

        Set<String> neighbors = getEdges(words, word);

        for (String neighbor : neighbors ) {
          if (visited.contains(neighbor)) {
            continue;
          }
          queue.add(neighbor);
          visited.add(neighbor);
        }
      }
      levelCount++;  // Increment level after processing all words in the current level
    }
    return 0;  // No path found
  }

  private Set<String> getEdges(Set<String> words, String word) {
    Set<String> edges = new HashSet<>();
    for (String element : words) {
      if (!diffCount(element, word)) {
        continue;
      }
      edges.add(element);
    }
    return edges;
  }

  private boolean diffCount(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return count == 1;
  }


}
