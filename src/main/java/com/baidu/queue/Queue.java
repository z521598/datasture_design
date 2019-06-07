package com.baidu.queue;

import com.baidu.common.PublicForTest;

public class Queue<T> {

    private T[] data;
    private int headIndex = 0;
    private int nextTailIndex = 0;


    public Queue() {
        data = (T[]) new Object[8];
    }

    public Queue(int i) {
        data = (T[]) new Object[i];
    }

    public void enqueue(T t) {
        if (nextTailIndex - headIndex == data.length - 1 || headIndex - nextTailIndex == 1) {
            resize();
        }
        data[nextTailIndex] = t;
        nextTailIndex = (nextTailIndex + 1) % data.length;
        System.out.println("[enqueue][debug]" + " head:" + headIndex + " tail:" + nextTailIndex);
        printDate();
    }

    private void printDate() {
        printDate(this.data);
    }

    private void printDate(Object[] objects) {
        for (Object o : objects) {
            if (o == null) {
                System.out.print("null ");
            } else {
                System.out.print(o.toString() + " ");
            }
        }
        System.out.println();
    }

    private void resize() {
        System.out.println("[resize][debug]");
        int newSize = data.length * 2;
        T[] newData = (T[]) new Object[newSize];
        if (nextTailIndex > headIndex) { // 数组未循环场景
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        } else { // 数组循环了的场景
            int newIndex = 0;
            for (int i = headIndex; i < data.length; i++) {
                newData[newIndex] = data[i];
                newIndex++;
            }
            printDate(newData);
            for (int i = 0; i < nextTailIndex; i++) {
                newData[newIndex] = data[i];
                newIndex++;
            }
            printDate(newData);
            headIndex = 0;
            nextTailIndex = data.length - 1;
            data = newData;
        }
    }

    public T dequeue() {
        if (headIndex == nextTailIndex) {
            throw new RuntimeException("queue is empty");
        }
        T res = data[headIndex];
        data[headIndex] = null;
        headIndex = (headIndex + 1) % data.length;
        System.out.println("[dequeue][debug]" + " head:" + headIndex + " tail:" + nextTailIndex);
        printDate();
        return res;
    }

    public int size() {
        return nextTailIndex - headIndex;
    }

    @PublicForTest
    public int dataSize() {
        return data.length;
    }
}
