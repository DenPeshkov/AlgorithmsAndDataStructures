package com.github.denpeshkov.algorithms.sorting.counting;

public class CountingSortStable {

  public static void sort(Integer[] arr, int k) {
    int[] counts = new int[k + 1];

    for (int a : arr) {
      counts[a]++;
    }

    for (int i = 1; i < counts.length; i++) {
      counts[i] += counts[i - 1];
    }

    Integer[] temp = new Integer[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      temp[counts[arr[i]] - 1] = arr[i];
      counts[arr[i]]--;
    }

    System.arraycopy(temp, 0, arr, 0, temp.length);
  }
}
