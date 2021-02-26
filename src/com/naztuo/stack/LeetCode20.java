package com.naztuo.stack;

import java.util.*;

public class LeetCode20 {

    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] zuo = {'[','{','('};
        char[] you = {']','}',')'};
        for(char c : s.toCharArray()) {
            for(int i = 0; i < you.length; i++) {
                if(you[i] == c) {
                    if(!stack.isEmpty() && zuo[i] == (char)stack.pop()) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            for(int i = 0; i < zuo.length; i++) {
                if(zuo[i] == c) {
                    stack.push(c);
                    continue;
                }
            }
        }
        return stack.isEmpty();
    }


    /**
     * 更优秀的写法
     */
    public boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(pairs.containsKey(c)) {
                if(stack.isEmpty() || stack.peek() !=  pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}
