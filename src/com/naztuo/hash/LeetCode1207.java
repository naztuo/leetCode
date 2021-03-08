package com.naztuo.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : arr) {
            numMap.put(num, numMap.get(num) == null ? 1 : numMap.get(num) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry : numMap.entrySet()) {
            if(!set.add(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
