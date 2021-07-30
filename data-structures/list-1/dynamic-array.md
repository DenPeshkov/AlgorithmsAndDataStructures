# Dynamic array

## Overview

List implemented using a resizing array.

## Implementation

```java
public class DynamicArray<E> implements List<E> {

  private static final int DEFAULT_CAPACITY = 16;

  private E[] arr;
  private int size;

  public DynamicArray() {
    arr = (E[]) new Object[DEFAULT_CAPACITY];
    size = 0;
  }

  @Override
  public void addFirst(E e) {
    if (size == arr.length) {
      resize(arr.length * 2);
    }

    System.arraycopy(arr, 0, arr, 1, size++);

    arr[0] = e;
  }

  @Override
  public void addLast(E e) {
    if (size == arr.length) {
      resize(arr.length * 2);
    }

    arr[size++] = e;
  }

  @Override
  public void add(int i, E e) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }

    if (size == arr.length) {
      resize(arr.length * 2);
    }

    System.arraycopy(arr, i, arr, i + 1, size++ - i);

    arr[i] = e;
  }

  @Override
  public E removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = arr[0];

    System.arraycopy(arr, 1, arr, 0, size - 1);

    arr[--size] = null;

    if (size > 0 && size == arr.length / 4) {
      resize(arr.length / 2);
    }

    return old;
  }

  @Override
  public E removeLast() {
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
  public E remove(int i) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }

    E item = arr[i];

    System.arraycopy(arr, i + 1, arr, i, size - i - 1);

    arr[--size] = null;

    if (size > 0 && size == arr.length / 4) {
      resize(arr.length / 2);
    }

    return item;
  }

  @Override
  public boolean remove(E item) {
    int index = indexOf(item);

    if (index == -1) {
      return false;
    }

    remove(index);

    return true;
  }

  @Override
  public E getFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return arr[0];
  }

  @Override
  public E getLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return arr[size - 1];
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    return arr[index];
  }

  @Override
  public E setFirst(E e) {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = arr[0];
    arr[0] = e;

    return old;
  }

  @Override
  public E setLast(E e) {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = arr[size - 1];
    arr[size - 1] = e;

    return old;
  }

  @Override
  public E set(int index, E item) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    E old = arr[index];
    arr[index] = item;

    return old;
  }

  @Override
  public int indexOf(E item) {
    for (int i = 0; i < size; i++) {
      if (item.equals(arr[i])) {
        return i;
      }
    }

    return -1;
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
    return new DynamicArrayIterator();
  }

  private void resize(int size) {
    arr = Arrays.copyOf(arr, size);
  }

  private class DynamicArrayIterator implements Iterator<E> {

    int i = 0;

    @Override
    public boolean hasNext() {
      return i < size;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      return arr[i++];
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
| `void addFirst(E e)` | $$O(n),\ O(n)$$ |
| `void addLast(E e)` | $$O(1),\ amortised\ O(1)$$ |
| `void add(int i, E e)` | $$O(n),\ O(n)$$ |
| `E removeFirst()` | $$O(n),\ O(n)$$ |
| `E removeLast()` | $$O(1),\ amortised\ O(1)$$ |
| `E remove(int i)` | $$O(n),\ O(n)$$ |
| `boolean remove(E item)` | $$O(n),\ O(n)$$ |
| `E getFirst()` | $$O(1),\ O(1)$$ |
| `E getLast()` | $$O(1),\ O(1)$$ |
| `E get(int index)` | $$O(1),\ O(1)$$ |
| `E setFirst(E e)` | $$O(1),\ O(1)$$ |
| `E setLast(E e)` | $$O(1),\ O(1)$$ |
| `E set(int index, E item)` | $$O(1),\ O(1)$$ |
| `int indexOf(E item)` | $$O(n),\ O(n)$$ |
| `int size()` | $$O(1),\ O(1)$$ |
| `boolean isEmpty()` | $$O(1),\ O(1)$$ |

