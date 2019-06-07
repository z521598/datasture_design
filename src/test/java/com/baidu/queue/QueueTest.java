package com.baidu.queue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    @Test
    public void testDequeuePush() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("str1");
        queue.enqueue("str2");
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeueResize() {
        Queue<String> queue = new Queue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue("str" + i);
        }
        assertEquals(20, queue.size());
        for (int i = 0; i < 20; i++) {
            assertEquals("str" + i, queue.dequeue());
        }
    }

    @Test
    public void testDequeue() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("str1");
        queue.enqueue("str2");
        assertEquals("str1", queue.dequeue());
        assertEquals("str2", queue.dequeue());
    }

    @Test
    public void testDeEmptyQueue() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("str1");
        assertEquals("str1", queue.dequeue());
        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void testGoodResizeByEnqueue() {
        Queue<Integer> queue = new Queue<>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(4, queue.dataSize());
    }


    @Test
    public void testDequeueAfterCycle() {
        Queue<Integer> queue = new Queue<>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(new Integer(3), queue.dequeue());
        assertEquals(new Integer(4), queue.dequeue());
        assertEquals(new Integer(5), queue.dequeue());
    }
}