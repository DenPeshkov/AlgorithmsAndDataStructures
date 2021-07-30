# Selection sort

## Overview

{% tabs %}
{% tab title="Псевдокод" %}
```text
Start with empty list S and unsorted list I of n items
for(i=0;i<n;i++) {
  x <- smallest item in I
  Remove x from I
  Append x to end of S
}
```
{% endtab %}

{% tab title="Псевдокод" %}
```
Start with empty list S and unsorted list I of n items
On each iteration move i-th smallest number from list S to list I
```
{% endtab %}
{% endtabs %}

## Implementation

```java
public class SelectionSort {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    int N = arr.length;

    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (arr[j].compareTo(arr[min]) < 0) {
          min = j;
        }
      }
      exchange(arr, i, min);
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
| $$O(1),\ O(1)$$  | $$O(n^2),\ O(n^2),\ O(n^2)$$ | Not stable |

## Notes

The number of comparisons does not depend on the initial ordering of the array elements.

Can be made stable by placing min in the resulting position and shifting all elements to the rights, instead of swapping.

