package org.dsa.examples.v1.strings;

public class PallindromeString {
  public boolean solution(String input) {
    return isPalin(input);
  }

  public boolean isPalin(String input) {
    if (input.length() == 1)
      return true;
    Character firstChar = input.charAt(0);
    Character lastChar = input.charAt(input.length() - 1);
    if (firstChar == lastChar) {
      input = input.substring(1, input.length() - 1);
      return isPalin(input);
    }
    return false;
  }
}
