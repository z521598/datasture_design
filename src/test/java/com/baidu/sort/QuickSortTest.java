package com.baidu.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {


    @Test
    public void quickSort() {
        Integer[] numbers = new Integer[]{34, 534, 63, 34, 32, 34, 234, 234, 1, 345, 6, 72, 24, 2, 1, 6, 45, 345};
        QuickSort.sort(numbers);
        assertEquals("[1, 1, 2, 6, 6, 24, 32, 34, 34, 34, 45, 63, 72, 234, 234, 345, 345, 534]", Arrays.asList(numbers).toString());
    }

    @Test
    public void quickSortV2() {
        Integer[] numbers = new Integer[]{34, 534, 63, 34, 32, 34, 234, 234, 1, 345, 6, 72, 24, 2, 1, 6, 45, 345};
        QuickSort.sortV2(numbers);
        assertEquals("[1, 1, 2, 6, 6, 24, 32, 34, 34, 34, 45, 63, 72, 234, 234, 345, 345, 534]", Arrays.asList(numbers).toString());
    }


}