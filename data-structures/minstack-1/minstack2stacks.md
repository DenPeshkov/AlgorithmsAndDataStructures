# MinStack2Stacks

## Overview

MinStack implemented using two stacks.

## Implementation

```java
public class MinStack2Stacks<E extends Comparable<? super E>> implements MinStack<E> {

  private final Stack<E> stack;
  private final Stack<E> minStack;

  public MinStack2Stacks(Supplier<Stack<E>> stackFactory) {
    stack = stackFactory.get();
    minStack = stackFactory.get();
  }

  @Override
  public E getMin() {
    return minStack.peek();
  }

  @Override
  public void push(E e) {
    stack.push(e);
    E min = minStack.isEmpty() ? e : min(e, getMin());
    minStack.push(min);
  }

  @Override
  public E pop() {
    E res = stack.pop();
    minStack.pop();
    return res;
  }

  @Override
  public E peek() {
    return stack.peek();
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
  public Iterator<E> iterator() {
    return stack.iterator();
  }

  private E min(E item1, E item2) {
    return item1.compareTo(item2) <= 0 ? item1 : item2;
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

