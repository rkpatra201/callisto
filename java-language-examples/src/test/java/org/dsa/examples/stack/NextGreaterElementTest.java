package org.dsa.examples.stack;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NextGreaterElementTest {

  @Test
  public void findNextGreaterElement() {
    int[] arr = {4, 5, 2, 25};
    List<Integer> list = new NextGreaterElement().findNextGreaterElement(arr);
    System.out.println(list);
  }

  @Test
  public void findNextGreaterElement_1() {
    int[] arr = {4, 9, 5, 2, 1, 10, 8}; //ans: 9, 10, 10, 10, 10, -1, -1
    List<Integer> list = new NextGreaterElement().findNextGreaterElement(arr);
    System.out.println(list);
  }
}