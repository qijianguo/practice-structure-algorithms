package com.qijianguo.algorithms.shell_sort;

/**
 * **********希尔排序***********
 * --------------------------
 * 原理：
 *   1.将数组按一定「增量」分组，分成多个子序列
 *   2.将子序列使用「直接插入」排序算法排序
 *   3.缩减增量，每次缩小为上一个增量的1/2，直至缩减到1时进行最后一次排序
 * --------------------------
 * 时间复杂度：
 *  1.最优
 *  2.最差
 * --------------------------
 * 适用场景：
 *  1.
 *  2.
 * --------------------------
 * @author qijianguo
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2, 69, 99};
        System.out.println("----------原始----------");
        print(array);
        System.out.println("------------------------");
        sort3(array);
        System.out.println("------------------------");
        System.out.println("----------结果----------");
        print(array);
    }

    private static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        // 1.将数组按一定「增量」分组，分成多个子序列(分组规则 len, len * 1/2, len * 1/4, len * 1/8...1)
        for (int d = len / 2; d >= 1; d /= 2) {
//            System.out.println("--------" + d + "---------");
            // 2.将子序列使用「直接插入」排序算法排序
            // 2.1 分组中的左边
            for (int left = 0; left < len - d; left++) {
//                System.out.println("left==============" + left + "================");
                // 2.2 分组中的右边
                for (int right = left + d; right < len; right += d) {
//                    System.out.println("right---------------" + right + "---------------");
                    // 2.3 满足条件后将两个数交换位置
                    if (array[left] > array[right]) {
                        int max = array[left];
                        array[left] = array[right];
                        array[right] = max;
                    }
                }
            }
            print(array);
        }


    }

    private static void sort3(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        // 1.将数组按一定「增量」分组，分成多个子序列(分组规则 len, len * 1/2, len * 1/4, len * 1/8...1)
        for (int d = len / 2; d >= 1; d /= 2) {
//            System.out.println("--------" + d + "---------");
            // 2.将子序列使用「直接插入」排序算法排序
            // 2.1 分组中的左边
            for (int left = 0; left < d; left++) {
//                System.out.println("left==============" + left + "================");
                // 2.2 分组中的右边
                for (int right = left + d; right < len; right += d) {
//                    System.out.println("right---------------" + right + "---------------");
                    // 2.3 满足条件后将两个数交换位置
                    int temp = array[right];
                    for (int prev = right - d; prev >= 0; prev -= d) {
                        if (array[prev] > temp) {
                            array[right] = array[prev];
                            array[prev] = temp;
                        }

                    }
                }
            }
            print(array);
        }
    }

    /**
     * https://www.jianshu.com/p/d730ae586cf3
     * @param array
     */
    private static void sort1(int[] array) {
        //希尔排序  升序
        for (int d = array.length / 2;d>0;d /= 2){ //d：增量  7   3   1
            for (int i = d; i < array.length; i++){
                System.out.println("------------" + i + "------------");
                //i:代表即将插入的元素角标，作为每一组比较数据的最后一个元素角标
                //j:代表与i同一组的数组元素角标
                for (int j = i-d; j>=0; j-=d){ //在此处-d 为了避免下面数组角标越界
                    System.out.println("===========" + j + "==============");
                    if (array[j] > array[j + d]) {// j+d 代表即将插入的元素所在的角标
                        //符合条件，插入元素（交换位置）
                        int temp = array[j];
                        array[j] = array[j + d];
                        array[j + d] = temp;
                    }
                }
                print(array);
            }
        }
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }


}
