# KWayMerge

## Overview

Implementation of k-way merge algorithm with $$k$$ sorted input arrays, using a [priority queue](../../data-structures/priority-queue/). Given implementation simultaneously merges k-runs together.

## Implementation

```java
public class KWayMerge {

  public static <T extends Comparable<? super T>> T[] merge(T[]... arrays) {
    int[] indexes = new int[arrays.length];
    T[] res = (T[]) Array.newInstance(getComponentType(arrays), length(arrays));
    PriorityQueue<MinIndPair<T>> priorityQueue = new MinBinaryHeapPriorityQueue<>();

    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i].length > 0) {
        priorityQueue.insert(new MinIndPair<>(i, arrays[i][0]));
      }
    }

    int k = 0;

    while (!priorityQueue.isEmpty()) {
      MinIndPair<T> minIndPair = priorityQueue.removeMin();
      T min = minIndPair.min;
      int ind = minIndPair.ind;

      res[k++] = min;
      indexes[ind]++;

      if (indexes[ind] < arrays[ind].length) {
        priorityQueue.insert(new MinIndPair<>(ind, arrays[ind][indexes[ind]]));
      }
    }

    return res;
  }

  private static <T extends Comparable<? super T>> Class<?> getComponentType(T[][] arrays) {
    return arrays.getClass().getComponentType().getComponentType();
  }

  private static <T> int length(T[]... arrays) {
    int length = 0;

    for (T[] arr : arrays) {
      length += arr.length;
    }

    return length;
  }

  private static class MinIndPair<T extends Comparable<? super T>> implements
      Comparable<MinIndPair<T>> {

    int ind;
    T min;
    Comparator<MinIndPair<T>> comparator;


    public MinIndPair(int ind, T min) {
      comparator = Comparator.comparing(pair -> pair.min);
      this.ind = ind;
      this.min = min;
    }

    @Override
    public int compareTo(MinIndPair<T> o) {
      return comparator.compare(this, o);
    }
  }
}
```

## Complexity

* $$k$$ - number of input arrays.
* $$n$$ - total number of elements.

| Space | Time |
| :--- | :--- |
| $$O(n),\ O(n)$$ | $$O(n*log\ k),\ O(n*log\ k),\ O(n*log\ k)$$ |

## Improvements

Use tournament tree instead of a [priority queue](../../data-structures/priority-queue/).

