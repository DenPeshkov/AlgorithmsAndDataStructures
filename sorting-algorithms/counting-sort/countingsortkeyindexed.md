# CountingSortKeyIndexed

## Overview

Implementation of counting sort that assumes that each of the $$n$$ input elements is an object with a key that is an integer in the range $$[0,\ k]$$, for some integer $$k$$. Objects are sorted using provided key.

## Implementation

```java
public class CountingSortKeyIndexed {

  public static <T> void sort(T[] arr, int k, ToIntFunction<T> keyExtractor) {
    int[] counts = new int[k + 1];

    for (T a : arr) {
      counts[keyExtractor.applyAsInt(a)]++;
    }

    for (int i = 1; i < counts.length; i++) {
      counts[i] += counts[i - 1];
    }

    T[] temp = (T[]) new Object[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      temp[counts[keyExtractor.applyAsInt(arr[i])] - 1] = arr[i];
      counts[keyExtractor.applyAsInt(arr[i])]--;
    }

    System.arraycopy(temp, 0, arr, 0, temp.length);
  }
}
```

## Complexity

* $$n$$ - number of elements.
* $$k$$ - maximum value of element's key.

| Space | Time | Stability |
| :--- | :--- | :--- |
| $$O(n+k),\ O(n+k)$$ | $$O(n+k),\ O(n+k)$$ | Stable |

