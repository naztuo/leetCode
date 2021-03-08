package com.naztuo.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Todo
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0;i < nums.length; i++) {

            for(int j = i+1; j < nums.length; j++) {
                if(hashTable.get(0-i-j) != null &&hashTable.get(0-i-j) > j) {
                    List<Integer> fix = new ArrayList<>(3);
                    fix.add(nums[i]);
                    fix.add(nums[j]);
                    fix.add(0-i-j);
                    list.add(fix);
                }
                hashTable.put(nums[j],j);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        new LeetCode15().threeSum(nums);
    }
}
