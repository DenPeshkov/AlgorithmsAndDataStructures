# List

## Overview

An abstract data type that represents a countable number of ordered values, where the same value may occur more than once.  An instance of a list is a computer representation of the mathematical concept of a finite sequence.

## API

```java
public interface List<E> extends Iterable<E> {

  void addFirst(E e);

  void addLast(E e);

  void add(int i, E e);

  E removeFirst();

  E removeLast();

  E remove(int i);

  boolean remove(E e);

  E getFirst();

  E getLast();

  E get(int i);

  E setFirst(E e);

  E setLast(E e);

  E set(int i, E e);

  int indexOf(E e);

  int size();

  boolean isEmpty();
}
```

