package com.naztuo.hash;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i =0 ; i< nums.length; i++) {

            if(map.get(target- nums[i]) != null) {
                return new int[]{i,map.get(target- nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
