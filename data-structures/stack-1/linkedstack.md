# LinkedStack

## Overview

Stack implemented using singly linked list.

## Implementation

```java
public class LinkedStack<E> implements Stack<E> {

  private Node<E> first;
  private int size;

  public LinkedStack() {
    size = 0;
    first = null;
  }

  @Override
  public void push(E e) {
    first = new Node<>(e, first);

    size++;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = first.item;
    first = first.next;

    size--;

    return old;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return first.item;
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

  private static class Node<E> {

    final E item;
    final Node<E> next;

    Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }
  }

  private class StackIterator implements Iterator<E> {

    Node<E> node = first;

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      E item = node.item;
      node = node.next;

      return item;
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
| `void push(E item)` | $$O(1),\ O(1)$$ |
| `E pop()` | $$O(1),\ O(1)$$ |
| `E peek()` | $$O(1),\ O(1)$$ |
| `int size()` | $$O(1),\ O(1)$$ |
| `boolean isEmpty()` | $$O(1),\ O(1)$$ |

## Notes

The main disadvantages of the linked list are:

* Each invocation of `void push(E item)` causes the memory manager to allocate memory for the new node.
* Memory allocations have very low granularity, hence overhead.
* Big memory overhead due to pointer in each node.



