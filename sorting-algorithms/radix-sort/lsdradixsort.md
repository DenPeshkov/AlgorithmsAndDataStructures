# LsdRadixSort

## Overview

Implementation of radix sort that assumes that each element of the input array has $$d$$ digits that are integers in the range $$[0, k]$$.

Digits are indexed from right to left, from lowest to highest.

```text
Start with list I of n items
Each item can be divided into d digits
for(i = 1 to d) {
  use a stable sort to sort I on digit i
}
```

## Implementation

```java
public class LsdRadixSort {

  public static <T> void sort(T[] arr, int d, int k, ToIntBiFunction<T, Integer> digitExtractor) {
    int[] counts = new int[k + 1];
    T[] temp = (T[]) new Object[arr.length];

    for (int i = 0; i < d; i++) {
      int finalI = i;
      CountingSortKeyIndexed.sort(arr, counts, temp, a -> digitExtractor.applyAsInt(a, finalI));
    }
  }

  static class CountingSortKeyIndexed {

    private static <T> void sort(T[]CountingSortKeyIndexed arr, int[] counts, T[] temp, ToIntFunction<T> keyExtractor) {
      Arrays.fill(counts, 0);

      for (T a : arr) {
        counts[keyExtractor.applyAsInt(a)]++;
      }

      for (int i = 1; i < counts.length; i++) {
        counts[i] += counts[i - 1];
      }

      for (int i = arr.length - 1; i >= 0; i--) {
        temp[counts[keyExtractor.applyAsInt(arr[i])] - 1] = arr[i];
        counts[keyExtractor.applyAsInt(arr[i])]--;
      }

      System.arraycopy(temp, 0, arr, 0, temp.length);
    }
  }
}
```

## Complexity

* $$k$$ - maximum value of digit.
* $$d$$ - number of digits in each element.
* $$n$$ - number of elements.
* $$b$$ - number of bits to represent elements.
* $$r$$ - number of bits to represent digit.

| Space | Time | Stability |
| :--- | :--- | :--- |
| $$O(k+n),\ O(k+n)$$ | $$O(d*(n+k)),\ O(d*(n+k)),\ O(d*(n+k))$$ | Stable |
| $$O(2^r+n),\ O(2^r+n)$$ | $$O((b/r)*(n+2^r))$$ | Stable |

## Implementation notes

Modified [CountingSortKeyIndexed](../counting-sort/countingsortkeyindexed.md) is used that takes `counts` and `temp` as parameters to save memory.

