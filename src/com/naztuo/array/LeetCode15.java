package com.naztuo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package com.naztuo.array
 * @Description: 三数之和
 * @Author zhaoxiao x5445
 * @Date 2021-03-26 15:32
 * @Version 1.0
 */
public class LeetCode15 {

    /**
     * 双指针移动
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSums(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int len = nums.length; //得到数组的长度
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //从小到大排序。
        int left, right;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) { //如果第一个数都大于0了，那么三个数相加一定大于0，直接跳过
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { //如果i的前一个数与当前想等，避免重复，跳过
                continue;
            }
            left = i + 1;
            right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); //三数相加等于0，直接放入
                    while (left < right && nums[left] == nums[left + 1]) { //如果left的下一个与left相等，避免重复，跳过
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) { //如果right的前一个与right相等，避免重复，跳过
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) { //如果大了，right指针要往前移
                    right--;
                } else if (sum < 0) { //如果小了，left指针要往后移
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, 4};
        System.out.println(new LeetCode15().threeSums(nums));
    }
}
