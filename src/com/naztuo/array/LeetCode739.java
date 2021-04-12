package com.naztuo.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Package com.naztuo.array
 * @Description: 天气
 * @Author zhaoxiao x5445
 * @Date 2021-03-29 14:53
 * @Version 1.0
 */
public class LeetCode739 {
    /**
     * 暴力解法
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 解法2 栈
     *
     * @param T
     * @return
     */
    public int[]  dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < res.length; i++) {
            int tempture = T[i];
            while(!stack.isEmpty() && T[stack.peek()] < tempture) {
                int current = stack.pop();
                res[current] = i - current;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tempertatues = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(new LeetCode739().dailyTemperatures(tempertatues));
    }
}
