# QuickSelectRecursive

## Overview

Recursive implementation of quickselect.

```text
Start with list I of n items
Choose pivot item v from I
Partition I into 3 unsorted lists I1, Iv, I2
- I1: All items < v
- Iv: All items = v
- I2: All items > v

If(k<|I1|) {
  Recursively find item with index k in I1
  Return it
}
Else if(k<|I1|+|Iv|) {
  Return v
}
Else {
  Recursively find item with index k-|I1|-|Iv| in I2
  Return it
}
```

## Implementation

```java
public class QuickSelectRecursive {

  public static <T extends Comparable<? super T>> T select(T[] arr, int k) {
    if (k < 1 || k > arr.length) {
      throw new IllegalArgumentException();
    }

    // 0-based indexing
    return select(arr, 0, arr.length - 1, k - 1);
  }

  public static <T extends Comparable<? super T>> T select(T[] arr, int lo, int hi, int k) {
    if (lo == hi) {
      return arr[lo];
    }
    int pivot = partition(arr, lo, hi);
    if (k == pivot) {
      return arr[k];
    } else if (k < pivot) {
      return select(arr, lo, pivot - 1, k);
    } else {
      return select(arr, pivot + 1, hi, k);
    }
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
| $$O(log\ n),\ O(n)$$ | $$O(n),\ O(n),\ O(n^2)$$ |

## Notes

If repeated values are present, k-th order statistic will be k-th number in the sorted array, not k-th smallest distinct number.

