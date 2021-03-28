package com.naztuo.hash;

import java.util.Arrays;

public class LeetCode204 {
    /**
     * 超出时间限制
     * @param num
     * @return
     */
    public int countPrimes1(int n) {
        if(n <=2 ) {
            return 0;
        }
        int j = 0;
        for(int i = 2; i < n; i++) {
            if(judgeNum(i)) {
                j++;
            }
        }
        return j;
    }


    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime,1);
        int ans = 0;
        for(int i = 2; i< n; i++) {
            if(isPrime[i] == 1) {
                ans +=1;
            }
            if((long) i * i < n) {
                for(int j = i * i;j <n;j = j +i) {
                    isPrime[j] = 0;
                }
            }
        }
        return ans;
    }

    private boolean judgeNum(int num) {
        for(int i = 2; i* i <= num;i++) {
            if(num %i ==0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
