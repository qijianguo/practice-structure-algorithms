package com.qijianguo.algorithms.array;

/**
 * 【爬楼梯】假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n 是一个正整数。
 *
 * 示例：
 *      输入： 2
 *      输出： 2
 *      解释： 有两种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶
 *      2.  2 阶
 * link: https://leetcode.com/problems/climbing-stairs/
 * @author qijianguo
 */
public class ClimbStairs {

    public static void main(String[] args){
        //System.out.println(fibonacci(45));
        System.out.println(dtgh(45));
    }

    private static int fibonacci01(int n) throws IllegalAccessException {
        if (n < 0) {
            throw new IllegalAccessException("num must bigger than zero!");
        }
        if (n == 1) {
            array[0] = n - 1;
            return 1;
        }
        if (n == 2) {
            array[0] = n - 1;
            return 2;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int[] array;

    private static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (array == null) {
            array = new int[n + 1];
        }
        if (n == 1 || n == 2) {
            array[n] = n;
        }
        if (array[n] != 0) {
            return array[n];
        }
        if (n == 1) return 1;
        if (n == 2) return 2;
        int c1 = array[n - 1] =  fibonacci(n - 1);
        int c2 = array[n - 2] = fibonacci(n - 2);
        return c1 + c2;
    }

    private static int dtgh(int n) {
        /**
         * 1    2   3   5
         *
         * 1 1
         * 2 2
         * 3 3
         * 4 5
         */
        int sum = 1;
        int one = 0;
        int two = 0;
        for (int i = 0; i < n; i++) {
            if (n <= 0) {
                return 0;
            }
            one = two;
            two = sum;
            sum = one + two;
        }
        return sum;
    }


}
