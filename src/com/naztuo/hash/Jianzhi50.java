package com.naztuo.hash;

import java.util.*;

public class Jianzhi50 {

    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Jianzhi50().firstUniqChar("leetcode"));
    }
}
