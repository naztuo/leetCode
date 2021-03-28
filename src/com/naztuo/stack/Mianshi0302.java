package com.naztuo.stack;

import java.util.Stack;

public class Mianshi0302 {
    private Stack<Integer> stack;
    private Stack<Integer> minRecord;

    /** initialize your data structure here. */
    public Mianshi0302() {
        this.stack = new Stack<>();
        this.minRecord = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minRecord.isEmpty() ||minRecord.peek()>=x) {
            minRecord.push(x);
        }
    }

    public void pop() {
        int res = stack.pop();
        if(minRecord.peek()>=res) {
            minRecord.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minRecord.peek();
    }

}
