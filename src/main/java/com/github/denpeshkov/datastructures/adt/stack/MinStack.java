package com.github.denpeshkov.datastructures.adt.stack;

import java.util.Iterator;

public class MinStack<T extends Comparable<? super T>> implements Iterable<T> {
  private final Stack<MinValuePair> stack;

  private class MinValuePair {
    private T min;
    private T value;

    public MinValuePair(T min, T value) {
      this.min = min;
      this.value = value;
    }

    public T getMin() {
      return min;
    }

    public T getValue() {
      return value;
    }

    public void setMin(T min) {
      this.min = min;
    }

    public void setValue(T value) {
      this.value = value;
    }
  }

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(T item) {
    T min = isEmpty() ? item : min(getMin(), item);
    stack.push(new MinValuePair(min, item));
  }

  public T pop() {
    return stack.pop().value;
  }

  public T peek() {
    return stack.peek().value;
  }

  public T getMin() {
    return stack.peek().getMin();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public int size() {
    return stack.size();
  }

  @Override
  public Iterator<T> iterator() {
    return new MinStackIterator(stack.iterator());
  }

  private class MinStackIterator implements Iterator<T> {
    private final Iterator<MinValuePair> stackIterator;

    private MinStackIterator(Iterator<MinValuePair> stackIterator) {
      this.stackIterator = stackIterator;
    }

    @Override
    public boolean hasNext() {
      return stackIterator.hasNext();
    }

    @Override
    public T next() {
      return stackIterator.next().getValue();
    }
  }

  private T min(T item1, T item2) {
    return item1.compareTo(item2) <= 0 ? item1 : item2;
  }
}
