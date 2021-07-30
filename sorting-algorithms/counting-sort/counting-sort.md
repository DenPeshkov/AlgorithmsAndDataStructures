# Counting sort

## Overview

Implementation of counting sort that assumes that each of the $$n$$ input elements is an integer in the range $$[0,\ k]$$, for some integer $$k$$.

## Implementation

```java
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
```

## Complexity

* $$n$$ - number of elements.
* $$k$$ - maximum value of element.

| Space | Time | Stability |
| :--- | :--- | :--- |
| $$O(k),\ O(k)$$ | $$O(n+k),\ O(n+k),\ O(n+k)$$ | Not stable |

