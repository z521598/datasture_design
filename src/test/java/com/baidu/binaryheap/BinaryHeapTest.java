package com.baidu.binaryheap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryHeapTest {

    @Test
    public void testNew() {
        BinaryHeap<Integer> binaryHeap = getHeap();
        binaryHeap.print();
        assertEquals("[1,5,2,6,7,3,8,9,10]", binaryHeap.get().toString().replaceAll(" ", ""));
    }


    @Test
    public void testAdd1() {
        BinaryHeap<Integer> binaryHeap = getHeap();
        binaryHeap.add(11);
        assertEquals("[1,5,2,6,7,3,8,9,10,11]", binaryHeap.get().toString().replaceAll(" ", ""));
        assertEquals(10, binaryHeap.getLength());
    }

    @Test
    public void testAdd2() {
        BinaryHeap<Integer> binaryHeap = getHeap();
        binaryHeap.add(-1);
        assertEquals("[-1,1,2,6,5,3,8,9,10,7]", binaryHeap.get().toString().replaceAll(" ", ""));
        assertEquals(10, binaryHeap.getLength());
    }

    @Test
    public void testDelete1() {
        BinaryHeap<Integer> binaryHeap = getHeap();
        binaryHeap.delete(10);
        assertEquals("[1,5,2,6,7,3,8,9]", binaryHeap.get().toString().replaceAll(" ", ""));
        assertEquals(8, binaryHeap.getLength());
    }

    @Test
    public void testDelete2() {
        BinaryHeap<Integer> binaryHeap = getHeap();
        binaryHeap.delete(1);
        assertEquals("[2,5,3,6,7,10,8,9]", binaryHeap.get().toString().replaceAll(" ", ""));
        assertEquals(8, binaryHeap.getLength());
    }

    private BinaryHeap<Integer> getHeap() {
        /*
        完全二叉树(in)：
                          7
                    1           3
                 10     5      2   8
               9    6

        */
        /*
        构建的最小堆(out)：
                          1
                     5          2
                  6     7      3   8
               9    10
         */
        Integer[] numbers = new Integer[]{
                7, 1, 3, 10, 5, 2, 8, 9, 6
        };
        return new BinaryHeap<>(numbers);

    }
}