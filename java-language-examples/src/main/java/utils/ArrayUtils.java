package utils;

public class ArrayUtils {

  public static void swap(int[] arr, int index1, int index2) {
    int value = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = value;
  }
}