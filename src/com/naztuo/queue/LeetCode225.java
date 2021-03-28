package com.naztuo.queue;


import java.util.LinkedList;

/**
 * todo 解法不对
 */
public class LeetCode225 {

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    public LeetCode225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.push(x);
    }

    public int pop() {
        if(queue1.isEmpty()) {
            while (!queue2.isEmpty()) {
                queue1.push(queue2.pop());
            }
            if(!queue1.isEmpty()) {
                return queue1.pop();
            }
        }
        return -1;
    }

    public int top() {
        if(queue1.isEmpty()) {
            return queue2.getLast();
        } else {
            return queue1.getFirst();
        }
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
