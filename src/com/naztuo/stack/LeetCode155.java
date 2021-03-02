package com.naztuo.stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode155 {

    private List stack;

    private int minVal;

    /** initialize your data structure here. */
    public LeetCode155() {
        stack = new ArrayList<Integer>();
    }

    public void push(int x) {
        stack.add(x);
        if(stack.size() == 1) {
            minVal = (int)stack.get(0);
        } else {
            if(x < minVal) {
                minVal = x;
            }
        }
    }

    public void pop() {
        int topValue = (int)stack.get(stack.size()-1);
        stack.remove(stack.size() -1);
        if(topValue == minVal && stack.size() > 0) {
            minVal = (int)stack.get(0);
            for (int i = 1; i< stack.size(); i++) {
                    if((int)stack.get(i) <minVal) {
                        minVal = (int)stack.get(i);
                    }
            }

        }


    }

    public int top() {
        return (int)stack.get(stack.size()-1);
    }

    public int getMin() {
        return minVal;
    }
}
