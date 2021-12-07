package com.qijianguo.algorithms.array;

/**
 * 【移动0】给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *      输入: [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 *      说明:
 *           必须在原数组上操作，不能拷贝额外的数组。
 *           尽量减少操作次数。
 *
 * link: https://leetcode-cn.com/problems/move-zeroes/
 * @author qijianguo
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        twoIndex(nums);
        print(nums);
    }

    /**
     * 两次遍历：
     * 第一次：遍历数组，遇到非0元素，则从第一个元素开始设置，并记录最近一次非0元素放置的索引「latestNonZeroIndex」
     * 第二次：将最后一次设置非0元素的索引后的位置用0补齐
     * 
     * @param nums
     */
    private static void moveAndReplace(int[] nums) {
        int latestNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前坐标不为0，则将值赋值给j所在位置
            if (nums[i] != 0) {
                nums[latestNonZeroIndex++] = nums[i];
            }
        }
        for (int i = latestNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针
     * @param nums
     */
    private static void twoIndex(int[] nums) {
        int latestZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[latestZeroIndex++] = nums[i];
                nums[i] = 0;
            }
        }
    }


    private static int[] f2(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                continue;
            }
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] != 0) {
                    num[i] = num[j];
                    num[j] = 0;
                    j ++;
                    break;
                }
            }
        }
        return num;
    }

    private static void print(int[] num) {
        for (int i : num) {
            System.out.printf("%d,", i);
        }
    }

}
