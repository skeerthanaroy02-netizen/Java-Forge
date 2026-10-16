package com.javaforge.datastructures;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    void shouldStartEmpty() {

        ArrayQueue<String> queue = new ArrayQueue<>(3);

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void shouldFollowFIFOOrder() {

        ArrayQueue<String> queue = new ArrayQueue<>(3);

        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("C++");

        assertEquals("Java", queue.dequeue());
        assertEquals("Python", queue.dequeue());
        assertEquals("C++", queue.dequeue());

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void shouldReuseArrayPositions() {

        ArrayQueue<Integer> queue = new ArrayQueue<>(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue());

        queue.enqueue(40);

        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldPeekWithoutRemoving() {

        ArrayQueue<String> queue = new ArrayQueue<>(3);

        queue.enqueue("Java");
        queue.enqueue("Python");

        assertEquals("Java", queue.peek());

        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());

        assertEquals("Java", queue.dequeue());
    }

    @Test
    void shouldThrowExceptionWhenFull() {

        ArrayQueue<Integer> queue = new ArrayQueue<>(2);

        queue.enqueue(10);
        queue.enqueue(20);

        assertThrows(IllegalStateException.class, () -> {
            queue.enqueue(30);
        });

        assertEquals(2, queue.size());
    }

    @Test
    void shouldThrowExceptionWhenEmpty() {

        ArrayQueue<String> queue = new ArrayQueue<>(3);

        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        });

        assertThrows(NoSuchElementException.class, () -> {
            queue.peek();
        });
    }

    @Test
    void shouldRejectInvalidCapacity() {

        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayQueue<String>(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayQueue<String>(-1);
        });
    }

}
