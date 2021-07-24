package com.github.denpeshkov.algorithms.sorting.insertion;

public class InsertionSort {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
      T key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j].compareTo(key) > 0) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
}
