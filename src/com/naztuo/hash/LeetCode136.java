package com.naztuo.hash;

import java.util.HashSet;
import java.util.Set;

public class LeetCode136 {

    /**
     * 解法1 异或
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        //异或
        for (int x : nums) {
            num ^= x;
        }
        return num;

    }

    /**
     * 解法2， hash表
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

}
