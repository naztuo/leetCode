package com.naztuo.stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Package com.naztuo.stack
 * @Description: 柱状图中最大的矩形
 * @Author zhaoxiao x5445
 * @Date 2021-03-29 9:28
 * @Version 1.0
 */
public class LeetCode84 {

    /**
     * 方法1，暴力解法
     *
     * @param heights
     * @return
     */
    public int maxJuxing(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxJuxin = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            maxJuxin = Math.max(maxJuxin, (right - left + 1) * heights[i]);
        }
        return maxJuxin;
    }

    /**
     * 方法2:栈
     *
     * @param heights
     * @return
     */
    public int maxJuXing(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while(!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while(!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if(stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(new LeetCode84().maxJuxing(heights));
    }
}
