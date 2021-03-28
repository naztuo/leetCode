package com.naztuo.stack;

import java.util.Stack;

public class LeetCode1021 {
    public String removeOuterParentheses(String S) {
        Stack<Character> outStack = new Stack<>();
        Stack<Character> inStack = new Stack<>();
        StringBuffer str = new StringBuffer();
        for(int i =0; i< S.length(); i++) {
            char current = S.charAt(i);
            if(outStack.isEmpty()) {
                outStack.push(current);
            } else {
                if(inStack.isEmpty()) {
                    if(current == '(') {
                        inStack.push(current);
                        str.append(current);
                    } else {
                        outStack.pop();
                    }
                } else {
                    if(inStack.peek() != current) {
                        inStack.pop();
                    } else {
                        inStack.push(current);
                    }
                    str.append(current);
                }
            }
        }
        return str.toString();
    }

    /**
     * todo 没看懂
     * @param S
     * @return
     */
    public String removeOuterParentheses1(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }

}
