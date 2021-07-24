package com.github.denpeshkov.datastructures.minqueue;

import com.github.denpeshkov.datastructures.queue.Queue;

public interface MinQueue<E> extends Queue<E> {

  E getMin();
}
