package org.dsa.examples.recursion;

import org.junit.Test;

import java.util.List;

public class WordDictionaryChainTest {

  @Test
  public void solution1() {
    String[] options={"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
    String source = "TOON";
    String target = "PLEA";
    List<String> result = new WordDictionaryChain().solution(source, target, options);
    System.out.println(result);
  }

  @Test
  public void solution2() {
    String[] options={"ABCD", "EBAD", "EBCD", "XYZA"};
    String source = "ABCV";
    String target = "EBAD";
    List<String> result = new WordDictionaryChain().solution(source, target, options);
    System.out.println(result);
  }

}