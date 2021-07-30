# Stack

## Overview

An abstract data type with LIFO policy.

## API

```java
public interface Stack<E> extends Iterable<E> {

  void push(E e);

  E pop();

  E peek();

  int size();

  boolean isEmpty();
}
```

