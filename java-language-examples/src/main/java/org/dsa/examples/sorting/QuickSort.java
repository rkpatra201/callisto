package org.dsa.examples.sorting;

public class QuickSort {

  public void solution(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  private void quickSort(int[] nums, int start, int end) {
    if (start >= end) {
      return;
    }
    int index = partition(nums, start, end);
    System.out.println(index);
    quickSort(nums, start, index - 1);
    quickSort(nums, index + 1, end);
  }


  public int partition1(int[] arr, int start, int end) {
    int smallIndex = start - 1;
    int pivot = arr[end];

    for (int i = start; i < end; i++) {
      if (arr[i] < pivot) {
        // Swap arr[i] and arr[smallIndex]
        smallIndex++;
        int temp = arr[i];
        arr[i] = arr[smallIndex];
        arr[smallIndex] = temp;
      }
    }

    int t = arr[smallIndex + 1];
    arr[smallIndex + 1] = arr[end];
    arr[end] = t;
    return smallIndex + 1;
  }

  private int partition(int[] arr, int start, int end) {
    int i = start;
    int j = end - 1;
    int pivot = arr[end];
    while (i <= j) {
      if (arr[i] < pivot) {
        i++;
      } else if (arr[j] > pivot) {
        j--;
      } else {
        // Swap out-of-place elements
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
    // left values | right values (here pivot might not be at right place)
    // swap pivot to correct position
    int temp = arr[end];
    arr[end] = arr[i];
    arr[i] = temp;
    return i;
  }
}
