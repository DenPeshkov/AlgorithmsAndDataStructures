# Priority queue

## Overview

A priority queue is an abstract data type similar to a regular [queue](../queue-1/) or [stack](../stack-1/) data structure in which each element additionally has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority.

## API

```java
public interface PriorityQueue<E> extends Iterable<E> {

  void insert(E e);

  E removeMin();

  E remove(int i);

  E getMin();

  void changeKey(int i, E e);

  int size();

  boolean isEmpty();
}
```

