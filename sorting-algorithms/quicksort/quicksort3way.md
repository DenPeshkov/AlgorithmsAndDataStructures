# QuickSort3Way

## Overview

Implementation of quicksort using 3-way partitioning.

```text
Start with list I of n items
Choose pivot item v from I
Partition I into 3 unsorted lists I1, Iv, I2
- I1: All items < v
- Iv: All items = v
- I2: All items > v

Sort I1 recursively, yielding sorted list S1
Sort I2 recursively, yielding sorted list S2
Concatenate S1, Iv, S2, yielding sorted list S
```

## Implementation

```java
public class QuickSort3Way {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    exchange(arr, lo, lo + ThreadLocalRandom.current().nextInt(hi - lo + 1));

    int pivot_lo = lo, pivot_mid = lo + 1, pivot_hi = hi;
    T v = arr[lo];
    while (pivot_mid <= pivot_hi) {
      int cmp = arr[pivot_mid].compareTo(v);
      if (cmp < 0) {
        exchange(arr, pivot_lo++, pivot_mid++);
      } else if (cmp > 0) {
        exchange(arr, pivot_mid, pivot_hi--);
      } else {
        pivot_mid++;
      }
    }

    sort(arr, lo, pivot_lo - 1);
    sort(arr, pivot_hi + 1, hi);
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
| $$O(log\ n),\ O(n)$$ | $$O(n),\ O(n\ log\ n),\ O(n^2)$$ | Not stable |

## Improvements

* The cutoff to [insertion sort](../insertion-sort/).
* Median-of-three partitioning.
* Can be implemented to use $$O(log\ n)$$ memory in the worst case by eliminating tail recursion. Use iteration approach on bigger subarray and recursion on smaller subarray.

