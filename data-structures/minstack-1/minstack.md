# MinStackPair

## Overview

MinStack implemented using min-value pairs.

## Implementation

```java
public class MinStackPair<E extends Comparable<? super E>> implements MinStack<E> {

  private final Stack<MinValuePair> stack;

  public MinStackPair(Supplier<Stack<MinValuePair>> stackFactory) {
    stack = stackFactory.get();
  }

  @Override
  public void push(E e) {
    E min = isEmpty() ? e : min(getMin(), e);

    stack.push(new MinValuePair(min, e));
  }

  @Override
  public E pop() {
    return stack.pop().value;
  }

  @Override
  public E peek() {
    return stack.peek().value;
  }

  @Override
  public int size() {
    return stack.size();
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public E getMin() {
    return stack.peek().min;
  }

  @Override
  public Iterator<E> iterator() {
    return new MinStackIterator();
  }

  private E min(E item1, E item2) {
    return item1.compareTo(item2) <= 0 ? item1 : item2;
  }

  public class MinValuePair {

    E min;
    E value;

    MinValuePair(E min, E value) {
      this.min = min;
      this.value = value;
    }
  }

  private class MinStackIterator implements Iterator<E> {

    final Iterator<MinValuePair> stackIterator;

    MinStackIterator() {
      this.stackIterator = stack.iterator();
    }

    @Override
    public boolean hasNext() {
      return stackIterator.hasNext();
    }

    @Override
    public E next() {
      return stackIterator.next().value;
    }
  }
}
```

## Complexity

* $$S(n)$$ - space complexity of wrapped [stack](../stack-1/) implementation.
* $$T(n)$$ - time complexity of the corresponding operation of wrapped [stack](../stack-1/) implementation.

| Space |
| :--- |
| $$S(n),\ S(n)$$ |

| Procedure | Time |
| :--- | :--- |
| `void push(E item)` | $$T(n),\ T(n)$$ |
| `E pop()` | $$T(n),\ T(n)$$ |
| `E peek()` | $$T(n),\ T(n)$$ |
| `int size()` | $$T(n),\ T(n)$$ |
| `boolean isEmpty()` | $$T(n),\ T(n)$$ |
| `E getMin()` | $$T(n),\ T(n)$$ |

