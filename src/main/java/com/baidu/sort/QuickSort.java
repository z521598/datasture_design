package com.baidu.sort;

import java.util.Arrays;

public class QuickSort {

    // 双边循环
    public static void sort(Integer[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    private static void quickSort(Integer[] elements, int startIndex, int endIndex) {
        System.out.println(Arrays.toString(elements));
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(elements, startIndex, endIndex);

        // 中间是ok的，不用放入递归比较
        quickSort(elements, startIndex, pivotIndex - 1);
        quickSort(elements, pivotIndex + 1, endIndex);
    }

    private static int partition(Integer[] elements, int startIndex, int endIndex) {
        int pivot = elements[startIndex];
        int leftIndex = startIndex;
        int rightIndex = endIndex;
        while (rightIndex != leftIndex) {
            while (rightIndex > leftIndex && elements[rightIndex] > pivot) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && elements[leftIndex] <= pivot) {
                leftIndex++;
            }
            if (rightIndex > leftIndex) {
                // 交换左右元素
                int temp = elements[rightIndex];
                elements[rightIndex] = elements[leftIndex];
                elements[leftIndex] = temp;
            }
        }
        // 交换基准与重合点
        elements[startIndex] = elements[leftIndex];
        elements[leftIndex] = pivot;
        return leftIndex;
    }

}
