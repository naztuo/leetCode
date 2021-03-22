package com.naztuo.stack;

import java.util.Stack;

public class LeetCode844 {

    public boolean backspaceCompare(String S, String T) {
        return dealStr(S).equals(dealStr(T));
    }

    private String dealStr(String str) {
        Stack a  = new Stack();
        for(char i : str.toCharArray()) {
            if( i != '#') {
                a.push(i);
            } else {
                if(!a.isEmpty()) {
                    a.pop();
                }
            }
        }
        StringBuilder b = new StringBuilder();
        while (!a.isEmpty()) {
            b.append(a.pop());
        }
        return b.toString();
    }
}
