package com.baidu.df;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * 你正在爬一个有n个台阶的楼梯，每次只能上 1个 或者 2个台阶，那么到达顶端共有多少种不同的方法？
 */
public class ClimbingStairs {
    /*
    最优子结构：假设从0到达第N个台阶的方法共有F(N)个。
    问题边界：F(0) = 0, F(1) = 1, F(2) = 2
    状态转移方程：F(n) = F(n-1) + F(n-2)
     */
    public static int entry(int n) {
        return v3(n);
    }

    // 递归
    private static int v1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return v1(n - 1) + v1(n - 2);
    }

    public static Map<Integer, Integer> MAP = new HashMap<>();

    // 备忘录算法(自顶向下)
    public static int v2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (MAP.containsKey(n)) {
            return MAP.get(n);
        }
        int val = v2(n - 1) + v2(n - 2);
        MAP.put(n, val);
        return val;
    }


    // 动态规划算法（自底向上）
    private static int v3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i < n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return a + b;
    }
}
