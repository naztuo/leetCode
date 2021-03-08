package com.naztuo.hash;

import java.util.HashMap;
import java.util.Map;

public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        return getStrMap(s).equals(getStrMap(t));
    }

    private Map<Character,Integer> getStrMap(String str) {
        char c;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< str.length(); i++) {
            c = str.charAt(i);
            map.put(c,map.get(c) == null ? 1 : map.get(c) + 1);
        }
        return map;
    }

    /**
     * 更优解
     * @param args
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode242().isAnagram("assss","ssass"));
    }
}
