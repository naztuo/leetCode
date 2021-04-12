package com.naztuo.diguifenzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 爬楼梯   todo 两种方式都超时了，看看为什么
 * @Author zhaoxiao x5445
 * @Date 2021-04-02 10:36
 * @Version 1.0
 */
public class LeetCode70 {
    //最简单的递归，这种递归由于会保存中间状态，会超时
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //保存中间状态的递归
    public int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int firstStep = 0;
        int secondStep = 0;
        if(map.get(n -1) == null) {
            firstStep = climbStairs1( n - 1);
            map.put(n - 1, firstStep);
        } else {
            firstStep = map.get(n - 1);
        }
        if(map.get(n -2) == null) {
            secondStep = climbStairs1( n - 2);
            map.put(n - 2, secondStep);
        } else {
            secondStep = map.get(n - 2);
        }
        map.put(n , firstStep + secondStep);
        return map.get(n);

    }

}
