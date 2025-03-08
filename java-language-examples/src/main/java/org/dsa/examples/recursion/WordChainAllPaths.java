package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The recursion tree sees sometimes a leaf node is becoming intermediate node.
 * so it is not a use case for memo approach.
 *
 * **Memoization is not suitable for this problem when using DFS with backtracking.
 * ** Here’s why:
 *
 * ### 🚫 **Why Memoization Won’t Work Well Here**
 * Memoization works best when:
 * - **Overlapping subproblems exist** (i.e., the same recursive calls return the same results).
 * - **Results can be reused** without affecting correctness.
 *
 * However, in **DFS with backtracking for finding all paths**, memoization doesn’t help because:
 * 1. **Paths are dynamic**: The path being explored depends on previous choices. Storing a previously computed result can lead to incorrect paths in new branches.
 * 2. **Each call depends on different state**: The state (visited nodes, path structure) differs between calls, so memoized results might not be valid.
 * 3. **No true overlapping subproblems**: Even if we reach the same word multiple times, the set of paths leading to it may differ. Storing a single best path for a word can discard valid paths.
 *
 * ### ✅ **When Memoization Can Help**
 * Memoization **does** work in **shortest path problems** (like BFS-based solutions), where:
 * - You track the shortest path from a node to the target.
 * - Paths do not change dynamically during recursion.
 *
 * ### **Conclusion**
 * - **For finding all paths → No Memoization (DFS + Backtracking is enough)**
 * - **For shortest path only → Memoization works in BFS but not in DFS**
 * - **For all shortest paths → Use BFS first, then DFS**
 *
 * Would you like to explore an optimized BFS-based approach for shortest paths? 🚀
 */
public class WordChainAllPaths {
  public static void main(String[] args) {
    solution("abc", "def",
        Set.of("kml", "abf", "ebf", "eef", "def", "dbc", "dec", "dez", "deh", "dei"),
        new ArrayList<>(), new HashSet<>());
  }

  private static int diffCount(String x, String y) {
    int diffCount = 0;
    for (int i = 0; i < y.length(); i++) {
      if (x.charAt(i) != y.charAt(i)) {
        diffCount++;
      }
      if (diffCount > 1) {
        break;
      }
    }
    return diffCount;
  }

  private static void solution(String startWord, String endWord,
                               Set<String> wordList,
                               List<String> paths,
                               Set<String> visited) {
    paths.add(startWord);

    if (startWord.equals(endWord)) {
      System.out.println(paths);
//      paths.remove(paths.size() - 1);
    }

    for (String word : wordList) {

      if (visited.contains(word)) {
        continue;
      }

      if (diffCount(startWord, word) == 1) {
        visited.add(word);
        solution(word, endWord, wordList, paths, visited);
        visited.remove(word);
      }
    }

    paths.remove(paths.size() - 1);
  }
}
