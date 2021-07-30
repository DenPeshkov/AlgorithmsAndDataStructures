# Merge

## Overview

Implementation of merge algorithm with two sorted arrays as input.

## Implementation

```java
public class Merge {

  public static <T extends Comparable<? super T>> T[] merge(T[] a, T[] b) {
    T[] res = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length + b.length);

    for (int i = 0, j = 0, k = 0; k < res.length; k++) {
      if (i >= a.length) {
        res[k] = b[j++];
      } else if (j >= b.length) {
        res[k] = a[i++];
      } else if (b[j].compareTo(a[i]) < 0) {
        res[k] = b[j++];
      } else {
        res[k] = a[i++];
      }
    }

    return res;
  }
}
```

## Complexity

* $$n$$ - number of elements in first array.
* $$m$$ - number of elements in second array.

| Space | Time |
| :--- | :--- |
| $$O(n+m),\ O(n+m)$$ | $$O(n+m),\ O(n+m),\ O(n+m)$$ |

## Notes

Can be used to merge two linked list in place.

Can be implemented to use $$O(1)$$ memory.

