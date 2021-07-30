# Heap

## Overview

Heap is a specialized tree-based data structure which is essentially an almost complete tree that satisfies the heap property: 

* In a max-heap, for any given node$$C$$, if$$P$$is a parent node of$$C$$, then the key \(the value\) of$$P$$is greater than or equal to the key of$$C$$. 
* In a min-heap, the key of$$P$$is less than or equal to the key of$$C$$.

## API

```java
public interface Heap<E> extends Iterable<E> {

  void insert(E e);

  E removeMin();

  E remove(int i);

  E getMin();

  void increaseKey(int i, E e);

  void decreaseKey(int i, E e);

  int size();

  boolean isEmpty();
}
```

