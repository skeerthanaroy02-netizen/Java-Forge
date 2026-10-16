package com.javaforge.datastructures;

import java.util.NoSuchElementException;

/**
 * A generic fixed-capacity queue backed by a circular array.
 *
 * <p>Elements are processed in FIFO (First In, First Out) order.
 * The queue does not grow automatically when full.</p>
 *
 * <p>Calling dequeue() or peek() on an empty queue throws
 * NoSuchElementException. Calling enqueue() on a full queue
 * throws IllegalStateException.</p>
 *
 * @param <T> the type of elements stored in the queue
 */

public class ArrayQueue<T> {

    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero."
            );
        }

        elements = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;


    }

    public void enqueue(T item) {
        if (size == elements.length) {
            throw new IllegalStateException("Queue is full.");

        }
        elements[rear] = item;
        rear = (rear + 1) % elements.length;

        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {

        if (size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }

        T item = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;

        return item;

    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }

        return (T) elements[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
