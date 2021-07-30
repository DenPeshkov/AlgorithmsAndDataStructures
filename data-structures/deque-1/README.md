# Deque

## Overview

An abstract data type that generalizes a [queue](../queue-1/), for which elements can be added to or removed from either the front \(head\) or back \(tail\).

## API

```java
public interface Deque<E> extends Iterable<E> {

  void addFirst(E e);

  void addLast(E e);

  E removeFirst();

  E removeLast();

  E first();

  E last();

  int size();

  boolean isEmpty();
}
```

