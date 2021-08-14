package com.github.denpeshkov.datastructures.minqueue;

import com.github.denpeshkov.datastructures.minstack.MinStack;
import com.github.denpeshkov.datastructures.minstack.MinStack2Stacks;
import com.github.denpeshkov.datastructures.stack.ArrayStack;
import com.github.denpeshkov.datastructures.stack.Stack;
import java.util.Iterator;

public class MinQueue2Stacks<E extends Comparable<? super E>> implements MinQueue<E> {

  private final MinStack<E> stack1;
  private final MinStack<E> stack2;

  public MinQueue2Stacks() {
    stack1 = new MinStack2Stacks<>();
    stack2 = new MinStack2Stacks<>();
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
