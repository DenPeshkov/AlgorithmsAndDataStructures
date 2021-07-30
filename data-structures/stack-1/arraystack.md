# ArrayStack

## Overview

Stack implemented using a resizing array.

## Implementation

```java
public class ArrayStack<E> implements Stack<E> {

  private static final int DEFAULT_CAPACITY = 16;

  private E[] arr;
  private int size;

  public ArrayStack() {
    arr = (E[]) new Object[DEFAULT_CAPACITY];
    size = 0;
  }

  @Override
  public void push(E item) {
    if (size == arr.length) {
      resize(arr.length * 2);
    }

    arr[size++] = item;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = arr[--size];
    arr[size] = null;

    if (size > 0 && size == arr.length / 4) {
      resize(arr.length / 2);
    }

    return old;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return arr[size - 1];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new StackIterator();
  }

  private void resize(int size) {
    arr = Arrays.copyOf(arr, size);
  }

  private class StackIterator implements Iterator<E> {

    int i = size;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      return arr[--i];
    }
  }
}
```

## Complexity

| Space |
| :--- |
| $$O(n),\ O(n)$$ |

| Procedure | Time |
| :--- | :--- |
| `void push(E item)` | $$O(1),\ amortised\ O(1)$$ |
| `E pop()` | $$O(1),\ amortised\ O(1)$$ |
| `E peek()` | $$O(1),\ O(1)$$ |
| `int size()` | $$O(1),\ O(1)$$ |
| `boolean isEmpty()` | $$O(1),\ O(1)$$ |

## Notes

The main disadvantage of resizing array is that `void push(E item)` and `E pop()` can take $$O(n)$$ time in the worst case, due to copy.

