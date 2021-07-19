package com.github.denpeshkov.datastructures.stack;

import java.util.Iterator;

public class MinStack<E extends Comparable<? super E>> implements Stack<E> {

  private final Stack<MinValuePair> stack;

  public MinStack() {
    stack = new ArrayStack<>();
  }

  private class MinValuePair {

    E min;
    E value;

    MinValuePair(E min, E value) {
      this.min = min;
      this.value = value;
    }
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

  public E getMin() {
    return stack.peek().min;
  }

  @Override
  public Iterator<E> iterator() {
    return new MinStackIterator();
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

  private E min(E item1, E item2) {
    return item1.compareTo(item2) <= 0 ? item1 : item2;
  }
}
