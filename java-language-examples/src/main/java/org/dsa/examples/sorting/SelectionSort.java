package org.dsa.examples.sorting;

public class SelectionSort {

  /**
   * selection sort:
   * 1,4,2,6,0,7,3
   * let say index = 0
   * find the minimumIndex in array by scanning from index to end of the array
   * swap the minimumIndex value with the value at index
   * increase the index.
   * repeat the above steps untill index reaches at the end of the array
   * --------------------------------------------------------------------------
   * <p>
   * index: 0
   * arr: [10, 3, 2, 5, 1, 7, 8, 9, -1]
   * finding minIndex fromIndex: 0
   * found minIndex: 8
   * swaping minIndex and index
   * after swap arr: [-1, 3, 2, 5, 1, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 1
   * arr: [-1, 3, 2, 5, 1, 7, 8, 9, 10]
   * finding minIndex fromIndex: 1
   * found minIndex: 4
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 5, 3, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 2
   * arr: [-1, 1, 2, 5, 3, 7, 8, 9, 10]
   * finding minIndex fromIndex: 2
   * found minIndex: 2
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 5, 3, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 3
   * arr: [-1, 1, 2, 5, 3, 7, 8, 9, 10]
   * finding minIndex fromIndex: 3
   * found minIndex: 4
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 4
   * arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * finding minIndex fromIndex: 4
   * found minIndex: 4
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 5
   * arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * finding minIndex fromIndex: 5
   * found minIndex: 5
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 6
   * arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * finding minIndex fromIndex: 6
   * found minIndex: 6
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 7
   * arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * finding minIndex fromIndex: 7
   * found minIndex: 7
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * increasing index
   * <p>
   * index: 8
   * arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * finding minIndex fromIndex: 8
   * found minIndex: 8
   * swaping minIndex and index
   * after swap arr: [-1, 1, 2, 3, 5, 7, 8, 9, 10]
   * increasing index
   * <p>
   *
   * @param arr
   */
  public void solution(int[] arr) {

    int index = 0;
    while (index < arr.length) {
      int minIndex = findMinIndex(arr, index);

      int tempValue = arr[minIndex];
      arr[minIndex] = arr[index];
      arr[index] = tempValue;

      index++;
    }

  }

  private int findMinIndex(int[] arr, int fromIndex) {
    int minIndex = fromIndex;
    int minValue = arr[minIndex];
    for (int i = fromIndex; i < arr.length; i++) {
      if (arr[i] < minValue) {
        minValue = arr[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

}
