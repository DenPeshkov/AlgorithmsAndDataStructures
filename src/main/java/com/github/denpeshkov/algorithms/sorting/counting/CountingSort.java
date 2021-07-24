package com.github.denpeshkov.algorithms.sorting.counting;

public class CountingSort {

  public static void sort(Integer[] arr, int k) {
    int[] counts = new int[k + 1];

    for (int a : arr) {
      counts[a]++;
    }

    int z = 0;
    for (int i = 0; i < counts.length; i++) {
      for (int j = 0; j < counts[i]; j++) {
        arr[z++] = i;
      }
    }
  }
}
