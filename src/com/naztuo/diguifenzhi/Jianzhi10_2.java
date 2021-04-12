package com.naztuo.diguifenzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 青蛙跳台阶，一次可以跳一个或两个，一共有多少种跳法
 * @Author zhaoxiao x5445
 * @Date 2021-03-18 16:17
 * @Version 1.0
 */
public class Jianzhi10_2 {
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 解法1，递归
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        //递归中可能存在多次计算的情况，用map保存起来

        //递归终止条件
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        int oneStep;
        int twoStep;
        if (map.get(n - 1) == null) {
            oneStep = numWays(n - 1) % 1000000007;
            map.put(n - 1, oneStep);
        } else {
            oneStep = map.get(n - 1);
        }
        if (map.get(n - 2) == null) {
            twoStep = numWays(n - 2) % 1000000007;
            map.put(n - 2, twoStep);
        } else {
            twoStep = map.get(n - 2);
        }
        map.put(n, (oneStep + twoStep) % 1000000007);
        return map.get(n);
    }

    /**
     * 解法2 迭代
     *
     * @param n
     * @return
     */
    public int solutionCount1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            sum = (first + second)% 1000000007;
            first = second % 1000000007;
            second = sum % 1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Jianzhi10_2().numWays(100));
        System.out.println(new Jianzhi10_2().solutionCount1(100));
    }
}
