# InsertionSortSwap

## Overview

Implementation of insertion sort using swapping.

```text
Start with empty list S and unsorted list I of n items
for(each item x in I) {
  insert x into S, in sorted order
}
```

## Implementation

```java
public class InsertionSortSwap {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
        exchange(arr, j, j - 1);
      }
    }
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
| $$O(1),\ O(1)$$  | $$O(n),\ O(n^2),\ O(n^2)$$  | Stable |

## Notes

The number of exchanges used by insertion sort is equal to the number of inversions in the array. The number of comparisons is at least equal to the number of inversions and at most equal to the number of inversions plus the array size minus 1. **So if we start with an array with a linear number of inversions, insertion sort will be linear time**.

If a balanced search tree is used instead of an array, insertion sort is $$O(n\ log\ n)$$ , but not used in practice because there are better algorithms.

{% hint style="info" %}
Great locality of reference.
{% endhint %}

