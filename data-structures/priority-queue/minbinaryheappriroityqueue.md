# MinBinaryHeapPriroityQueue

## Overview

Priority queue implemented using [binary min-heap](../heap/minbinaryheap.md).

## Implementation

```java
public class MinBinaryHeapPriorityQueue<E extends Comparable<? super E>> implements
    PriorityQueue<E> {

  private final MinBinaryHeap<E> minBinaryHeap;

  public MinBinaryHeapPriorityQueue() {
    minBinaryHeap = new MinBinaryHeap<>();
  }

  public MinBinaryHeapPriorityQueue(E[] arr) {
    minBinaryHeap = new MinBinaryHeap<>(arr);
  }

  @Override
  public void insert(E item) {
    minBinaryHeap.insert(item);
  }

  @Override
  public E removeMin() {
    return minBinaryHeap.removeMin();
  }

  @Override
  public E remove(int i) {
    return minBinaryHeap.remove(i);
  }

  @Override
  public E getMin() {
    return minBinaryHeap.getMin();
  }

  @Override
  public void changeKey(int i, E e) {
    minBinaryHeap.increaseKey(i, e);
    minBinaryHeap.decreaseKey(i, e);
  }

  @Override
  public int size() {
    return minBinaryHeap.size();
  }

  @Override
  public boolean isEmpty() {
    return minBinaryHeap.isEmpty();
  }

  public void merge(MinBinaryHeapPriorityQueue<E> priorityQueue) {
    minBinaryHeap.merge(priorityQueue.minBinaryHeap);
  }

  @Override
  public Iterator<E> iterator() {
    return minBinaryHeap.iterator();
  }
}
```

## Complexity

| Space |
| :--- |
| $$O(n),\ O(n)$$ |

| Procedure | Time |
| :--- | :--- |
| `MinBinaryHeapPriorityQueue(E[] arr)` | $$O(n),\ O(n)$$ |
| `void insert(E e)` | $$O(1),\ amortised\ O(log\ n)$$ |
| `E removeMin()` | $$O(log\ n),\ O(log\ n)$$ |
| `E remove(int i)` | $$O(log\ n),\ O(log\ n)$$ |
| `E getMin()` | $$O(1),\ O(1)$$ |
| `void changeKey(int i, E e)` | $$O(log\ n),\ O(log\ n)$$ |
| `int size()` | $$O(1),\ O(1)$$ |
| `boolean isEmpty()` | $$O(1),\ O(1)$$ |
| `void merge(MinBinaryHeapPriorityQueue<E> priorityQueue)` | $$O(n),\ O(n)$$ |



