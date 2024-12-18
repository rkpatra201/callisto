package org.dsa.examples.strings;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PallindromeStringTest {

  private String input;
  private boolean result;

  public PallindromeStringTest(String input, boolean result) {
    this.input = input;
    this.result = result;
  }


  @Parameterized.Parameters(name = "Test case {index}: input={0}, expected={1}")
  public static Collection<Object[]> data1() {
    return Arrays.asList(new Object[][]{
        {"madam", true},
        {"a", true},
        {"ab", false},
    });
  }

  @Test
  public void solution() {
    PallindromeString pallindromeString = new PallindromeString();
    boolean result = pallindromeString.isPalin(input);
    Assert.assertEquals(result, this.result);
  }
}