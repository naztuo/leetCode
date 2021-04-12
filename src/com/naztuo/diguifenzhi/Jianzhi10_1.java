package com.naztuo.diguifenzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 斐波那契数列
 * @Author zhaoxiao x5445
 * @Date 2021-03-18 16:41
 * @Version 1.0
 */
public class Jianzhi10_1 {

    Map<Integer, Integer> map = new HashMap<>();
    /**
     * 解法1，递归
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(map.get(n) != null) {
            return map.get(n);
        }
        int first;
        if (map.get(n - 1) == null) {
            first = fib(n - 1) % 1000000007;
            map.put(n - 1, first);
        } else {
            first = map.get(n - 1);
        }
        int right;
        if (map.get(n - 2) == null) {
            right = fib(n - 2) % 1000000007;
            map.put(n - 2, right);
        } else {
            right = map.get(n - 2);
        }
        map.put(n,(first + right) % 1000000007);
        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Jianzhi10_1().fib(100));
    }
}
