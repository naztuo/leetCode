package com.naztuo.queue;

import java.util.PriorityQueue;

public class LeetCode703 {

    PriorityQueue<Integer> pq;
    int k;

    public LeetCode703(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,-1};
        LeetCode703 leetCode703 = new LeetCode703(3,nums);
        leetCode703.add(2);

    }
}
