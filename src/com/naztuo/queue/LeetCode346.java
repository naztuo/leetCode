package com.naztuo.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode346 {

    int size, windowSum = 0, count = 0;
    Deque deque = new ArrayDeque<Integer>();

    public LeetCode346(int size) {
        this.size = size;
    }

    public double next(int val) {
        count++;
        deque.add(val);
        int tail = count > size ? (int) deque.poll() : 0;
        windowSum = windowSum - tail + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}
