package com.naztuo.hash;

import java.util.HashSet;
import java.util.Set;

public class JIanzhi03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
