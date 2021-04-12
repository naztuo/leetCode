package com.naztuo.array;

/**
 * @Package com.naztuo.array
 * @Description: 盛最多水的容器
 * @Author zhaoxiao x5445
 * @Date 2021-03-26 14:42
 * @Version 1.0
 */
public class LeetCode11 {


    /**
     * 思路：利用双指针分别指向左右两边，计算出桶的容量，然后将高度比较小的指针向里侧移动，计算大小
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            if (height[i] > height[j]) {
                res = Math.max(res, height[j] * (j - i));
                j--;
            } else {
                res = Math.max(res, height[i] * (j - i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new LeetCode11().maxArea(nums));
    }
}
