# QuickSort

## Overview

Implementation of quicksort using 2-way partitioning.

```text
Start with list I of n items
Choose pivot item v from I
Partition I into 2 unsorted lists I1 and I2
- I1: All items <= v
- I2: All items >= v
- The pivot v does not go into either list

Sort I1 recursively, yielding sorted list S1
Sort I2 recursively, yielding sorted list S2
Concatenate S1, v, S2, yielding sorted list S
```

## Implementation

```java
public class QuickSort {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int pivot = partition(arr, lo, hi);
    sort(arr, lo, pivot - 1);
    sort(arr, pivot + 1, hi);
  }

  private static <T extends Comparable<? super T>> int partition(T[] arr, int lo, int hi) {
    exchange(arr, lo, lo + ThreadLocalRandom.current().nextInt(hi - lo + 1));

    int i = lo, j = hi + 1;
    T v = arr[lo];
    while (true) {
      while (arr[++i].compareTo(v) < 0) {
        if (i == hi) {
          break;
        }
      }
      while (arr[--j].compareTo(v) > 0) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exchange(arr, i, j);
    }
    exchange(arr, lo, j);
    return j;
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
```

## Complexity

| Space | Time | Stability |
| :--- | :--- | :--- |
| $$O(log\ n),\ O(n)$$ | $$O(n\ log\ n),\ O(n\ log\ n),\ O(n^2)$$ | Not stable |

## Improvements

* The cutoff to [insertion sort](../insertion-sort/).
* Median-of-three partitioning.
* Can be implemented to use $$O(log\ n)$$ memory in the worst case by eliminating tail recursion. Use iteration approach on bigger subarray and recursion on smaller subarray.

