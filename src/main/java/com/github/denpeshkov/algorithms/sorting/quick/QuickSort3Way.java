package com.github.denpeshkov.algorithms.sorting.quick;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort3Way {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int p, int r) {
    if (r <= p) {
      return;
    }

    exchange(arr, p, p + ThreadLocalRandom.current().nextInt(r - p + 1));

    int lt = p, i = p + 1, gt = r;
    T v = arr[p];
    while (i <= gt) {
      int cmp = arr[i].compareTo(v);
      if (cmp < 0) {
        exchange(arr, lt++, i++);
      } else if (cmp > 0) {
        exchange(arr, i, gt--);
      } else {
        i++;
      }
    }

    sort(arr, p, lt - 1);
    sort(arr, gt + 1, r);
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
