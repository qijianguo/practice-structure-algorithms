package com.qijianguo.algorithms.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qijianguo
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 */
public class TwoSum {

    /**
     * 暴力解法：双层loop
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum01(int[] nums, int target) {
        for(int i = 0; i < nums.length; i ++) {
            // 遍历
            for(int j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Hash表法：将所有元素存入hash表，然后用target - loop[i], 如果结果在hash表中，则返回结果
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, index};
            }
        }
        return null;
    }

    /**
     * 双指针算法：核心是对数组进行排序
     *
     * 测试用例：{-1,-2,-3,-4,-5}, -8 执行错误
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum03(int[] nums, int target) {
        int [] sortArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortArr);
        int j = sortArr.length - 1;
        int i = 0;
        while (true) {
            int sum = sortArr[i] + sortArr[j];
            if (sum == target) {
                break;
            } else {
                if (sum > target) {
                    j = j - 1;
                } else {
                    i = i + 1;
                }
            }
        }
        int[] result = new int[]{-1, -1};
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == sortArr[i] && result[0] == -1) {
                result[0] = k;
                continue;
            }
            if (nums[k] == sortArr[j] && result[1] == -1) {
                result[1] = k;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum02(new int[]{-1,-2,-3,-4,-5}, -8);
        System.out.println(ints);

    }

}
