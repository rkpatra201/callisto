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

    int levelCount = 1;  // Start from 1 because beginWord is included in the possible sequence

    while (!queue.isEmpty()) {
      int size = queue.size(); // Process all words in the current level
      for (int i = 0; i < size; i++) {
        String word = queue.poll();

        if (word.equals(endWord)) {
          return levelCount;
        }

        Set<String> neighbors = getEdges(words, word);

        for (String neighbor : neighbors) {
          if (visited.contains(neighbor)) { // this way we reduce the number of levels also avoid facing in visiting same word which may cause infinite loop.
            continue;
          }
          queue.add(neighbor);
          visited.add(neighbor);
        }
      }
      levelCount++;  // Increment level after processing all words in the current level. Any node present in this level is a valid transistion from prev step
    }
    return 0;  // No path found
  }

  /**
   * hit : count = 1
   * visited: hit
   * queue: hit
   * <p>
   * <p>
   * pop: hit, queue: []
   * edges: hot
   * visited: hit, hot
   * queue: hot
   * count++ for level once
   * count=2
   * <p>
   * pop: hot, queue: [], count = 2
   * edges: hit, dot*, lot* but (hit is already visited skip it)
   * visited: hit, hot, dot, lot
   * queue: dot, lot
   * count++ for level once
   * count=3
   * <p>
   * pop: dot, queue [lot], count = 3
   * edges: hot, dog*, lot but (hot, lot already visited skip it)
   * visited : hit, hot, dot, lot, dog
   * queue: lot, dog
   * <p>
   * pop: lot, queue[dog], count = 3
   * edges: hot, log*, dot (hot and dot skipped)
   * visited: hit, hot, dot, lot, dog, log
   * queue: dog, log
   * count++ for level once
   * count=4
   * <p>
   * pop: dog, queue[log], count = 4
   * edges: dot, log, cog*
   * visited: hit, hot, dot, lot, dog, log, cog
   * queue: log, cog
   * <p>
   * pop: log, queue[cog], count = 4
   * edges: lot, dog, cog
   * visited: hit, hot, dot, lot, dog, log, cog
   * queue: cog
   * count++ for level once
   * count=5
   * <p>
   * pop: cog, queue[], count = 5
   * matches so return count
   *
   * @param words
   * @param word
   * @return
   */

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
