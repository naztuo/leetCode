package com.naztuo.diguifenzhi;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: X的幂方
 * @Author zhaoxiao x5445
 * @Date 2021-03-18 10:53
 * @Version 1.0
 */
public class LeetCode50 {
    /**
     * 解法1 递归（分治）
     *
     * @param x
     * @param N
     * @return
     */
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, n);
    }


    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, n);
    }

    public double quickMul1(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double cur = quickMul1(x, n / 2);
        if (n % 2 == 0) {
            return cur * cur;
        } else {
            return cur * cur * x;
        }
    }


    public double myPow1(double x, int n) {
        if (x == 0.0f) {
            return 0.0d;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            //这一步作用是能看懂的，就是判断奇偶，奇数就再乘一次，但是意思没有看懂
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            //右移一位，相当于除以2
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(9 / 2);
        System.out.println(2 / 2);

        System.out.println(new LeetCode50().myPow1(2, 5));
    }
}
