# QuickSelect

## Overview

Iterative implementation of quickselect.

## Implementation

```java
public class QuickSelect {

  public static <T extends Comparable<? super T>> T select(T[] arr, int k) {
    if (k < 1 || k > arr.length) {
      throw new IllegalArgumentException();
    }

    // 0-based indexing
    k = k - 1;

    int lo = 0;
    int hi = arr.length - 1;

    while (hi > lo) {
      int pivot = partition(arr, lo, hi);

      if (pivot < k) {
        lo = pivot + 1;
      } else if (pivot > k) {
        hi = pivot - 1;
      } else {
        return arr[k];
      }
    }
    return arr[k];
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

| Space | Time |
| :--- | :--- |
| $$O(1),\ O(1)$$ | $$O(n),\ O(n),\ O(n^2)$$ |

## Notes

If repeated values are present, k-th order statistic will be k-th number in the sorted array, not k-th smallest distinct number.



