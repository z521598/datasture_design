package com.baidu.sort;

/**
 * 1.双向
 * 偶数轮：从左向右
 * 奇数轮：从右向左
 *
 * 2.设置边界
 *
 * 3.提前返回
 */
public class CocktailSort {
    public static void sort(Integer[] elements) {
        for (int i = 0; i < elements.length / 2; i++) {
            boolean isSorted = true;
            for (int j = i; j < elements.length - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            for (int k = elements.length - 1 - i; k > i; k--) {
                if (elements[k] < elements[k - 1]) {
                    int temp = elements[k];
                    elements[k] = elements[k - 1];
                    elements[k - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

        }
    }
}
