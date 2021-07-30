# MinQueue2Stacks

## Overview

MinQueue implemented using two [stacks with minimum support](../minstack-1/minstack2stacks.md) over [stack implemented using a resizing array](../stack-1/arraystack.md).

![MinQueue implemented using two MinStack&apos;s](../../.gitbook/assets/a.png)

## Implementation

```java
public class MinQueue2Stacks<E extends Comparable<? super E>> implements MinQueue<E> {

  private final MinStack<E> stack1;
  private final MinStack<E> stack2;

  public MinQueue2Stacks() {
    stack1 = new MinStack2Stacks<>(ArrayStack::new);
    stack2 = new MinStack2Stacks<>(ArrayStack::new);
  }

  @Override
  public void enqueue(E e) {
    stack1.push(e);
  }

  @Override
  public E dequeue() {
    if (stack2.isEmpty()) {
      move();
    }

    return stack2.pop();
  }

  @Override
  public E peek() {
    if (stack2.isEmpty()) {
      move();
    }

    return stack2.peek();
  }

  @Override
  public int size() {
    return stack1.size() + stack2.size();
  }

  @Override
  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }

  @Override
  public E getMin() {
    if (stack2.isEmpty()) {
      return stack1.getMin();
    } else if (stack1.isEmpty()) {
      return stack2.getMin();
    } else {
      E stack1Min = stack1.getMin();
      E stack2Min = stack2.getMin();

      return stack1Min.compareTo(stack2Min) < 0 ? stack1Min : stack2Min;
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new MinQueueIterator();
  }

  private void move() {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
  }

  private class MinQueueIterator implements Iterator<E> {

    final Iterator<E> stack1Iterator;
    final Iterator<E> stack2Iterator;

    public MinQueueIterator() {
      Stack<E> tempStack1 = new ArrayStack<>();

      for (E e : stack1) {
        tempStack1.push(e);
      }

      stack1Iterator = tempStack1.iterator();
      stack2Iterator = stack2.iterator();
    }

    @Override
    public boolean hasNext() {
      return stack2Iterator.hasNext() || stack1Iterator.hasNext();
    }

    @Override
    public E next() {
      return stack2Iterator.hasNext() ? stack2Iterator.next() : stack1Iterator.next();
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
| `void enqueue(E e)` | $$O(1),\ amortised\ O(1)$$ |
| `E dequeue()` | $$O(1),\ amortised\ O(1)$$ |
| `E peek()` | $$O(1),\ amortised\ O(1)$$ |
| `int size()` | $$O(1),\ O(1)$$ |
| `boolean isEmpty()` | $$O(1),\ O(1)$$ |
| `E getMin()` | $$O(1),\ O(1)$$ |

## Implementation notes

Can be implemented using min variable to store minimum in first stack and stack with minimum support.

`E Peek()` can be implemented using a variable to store the head element in the first stack.

