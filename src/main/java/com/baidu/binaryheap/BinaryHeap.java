package com.baidu.binaryheap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// 最小堆：任意一个父节点的值，都大于或者等于它左右孩子节点的值。
public class BinaryHeap<T extends Comparable> {
    private T[] data;
    private int length;

    /**
     * 让所有非叶子节点依次"下沉"(从右到左，从下到上)
     */
    public BinaryHeap(T[] datas) {
        this.data = datas;
        this.length = datas.length;
        // 所有非叶子节点，依次下沉。
        for (int i = (length - 2) / 2; i >= 0; i--) {
            downAdjust(i);
        }
    }

    // 左孩子为2i+1；右孩子为2i+2
    private void downAdjust(int parentIndex) {
        // 临时保存
        T temp = data[parentIndex];

        // 先左孩子
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 若存在右️孩子，且比左孩子大，则定位到右孩子
            if (childIndex + 1 < length && data[childIndex + 1].compareTo(data[childIndex]) < 0) {
                childIndex++;
            }
            // 无需调整
            if (temp.compareTo(data[childIndex]) <= 0) {
                break;
            }

            // 交互
            data[parentIndex] = data[childIndex];
            parentIndex = childIndex;
            data[parentIndex] = temp;
            childIndex = 2 * childIndex + 1;
        }
    }

    public void add(T t) {
        length++;
        if (length > data.length) {
            resize();
        }
        data[length - 1] = t;
        upAdjust(length - 1);
    }

    private void resize() {
        T[] newData = (T[]) Array.newInstance(Comparable.class, length * 2);
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private void upAdjust(int childIndex) {
        T temp = data[childIndex];
        int parentIndex = (childIndex - 1) / 2;
        while (parentIndex >= 0) {
            if (temp.compareTo(data[parentIndex]) >= 0) {
                return;
            }
            data[childIndex] = data[parentIndex];
            childIndex = parentIndex;
            data[parentIndex] = temp;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    /**
     * 先删除，将最后一个节点放在删除位置上，并对其进行下沉调整
     */
    public void delete(T t) {
        if (t == null) {
            return;
        }
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (data[i].equals(t)) {
                index = i;
            }
        }
        if (index == -1) {
            return;
        }
        // 删除
        data[index] = data[length - 1];
        data[length - 1] = null;
        length--;
        downAdjust(index);
    }

    public List<T> get() {
        List<T> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            res.add(data[i]);
        }
        return res;
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + "  ");
            if ((Math.log(i + 2) / Math.log(2)) % 1 == 0.0d) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    public int getLength() {
        return length;
    }
}
