package org.dsa.examples.v1.recursion;

// https://workat.tech/problem-solving/approach/wm/wildcard-matching

// leetcode : hard
public class WildCardMatching {

  public boolean solution(String str, String pattern) {
    return solution(str.toCharArray(), pattern.toCharArray(), 0, 0);
  }

  private boolean solution(char[] s, char[] p, int n, int m) {

    if (n == s.length && m == p.length){
      return true;
    }

    if (n == s.length) {
      for (int i = m; i < p.length; i++) {
        if (p[i] != '*') {
          return false;
        }
      }
      return true;
    }

    if (m == p.length) {
      return false;
    }

    boolean matched = false;
    if (p[m] == '?' || s[n] == p[m]) {
      matched = solution(s, p, n + 1, m + 1);
    } else if (p[m] == '*') {
      matched = solution(s, p, n + 1, m) || solution(s, p, n, m + 1);
    }
    return matched;
  }
}
