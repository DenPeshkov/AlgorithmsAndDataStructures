# Queue

## Overview

An abstract data type with FIFO policy.

## API

```java
public interface Queue<E> extends Iterable<E> {

  void enqueue(E e);

  E dequeue();

  E peek();

  int size();

  boolean isEmpty();
}
```

