package com.naztuo.diguifenzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 中心对称数
 * @Author zhaoxiao x5445
 * @Date 2021-04-08 18:59
 * @Version 1.0
 */
public class LeetCode247 {
    public List<String> findStrobogrammatic(int n) {
        // 第一步：判断输入或者状态是否非法？
        if (n < 0) {
            throw new IllegalArgumentException("invalid input");
        }
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        //终止条件
        if (n == 0) return new ArrayList<>();
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        //递归
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for(String s : list) {
            if (n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }

    private List<String> helper1(int n, int m) {
        if(n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if(n == 1) {
            return new ArrayList<>(Arrays.asList("0","1","8"));
        }
        List<String> res = helper1(n -2 ,m);
        for(String s : res) {
            if(n != m) {
                res.add("0" + s +"0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
