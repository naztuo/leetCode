package com.naztuo.hash;

import java.util.*;

/**
 * @Package com.naztuo.hash
 * @Description: 字母异位词分组
 * @Author zhaoxiao x5445
 * @Date 2021-03-30 14:51
 * @Version 1.0
 */
public class LeetCode49 {
    /**
     * 方法1 排序
     *
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String newStr = new String(array);
            List<String> currentList = resultMap.getOrDefault(newStr, new ArrayList<>());
            currentList.add(str);
            resultMap.put(newStr, currentList);
        }
        return new ArrayList<>(resultMap.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i)).append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = resultMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            resultMap.put(key, list);
        }
        return new ArrayList<>(resultMap.values());
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tae", "eta", "asjhd", "dsf", "fsd"};
        new LeetCode49().groupAnagrams2(strs);
    }

}
