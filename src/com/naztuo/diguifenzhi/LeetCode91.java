package com.naztuo.diguifenzhi;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 解码方法  todo 超时了
 * @Author zhaoxiao x5445
 * @Date 2021-04-08 16:33
 * @Version 1.0
 */
public class LeetCode91 {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        return decode(cs, cs.length - 1);
    }

    private int decode(char[] cs, int index) {
        if (index <= 0) { //只有一个数字，那肯定只有一种解法
            return 1;
        }
        int count = 0;
        char cur = cs[index];
        char prev = cs[index - 1];
        if (cur > '0') {  // 当前字符比 “0” 大，则直接利用它之前的字符串所求得的结果
            count = decode(cs, index - 1);
        }
        if (prev == '1' || (prev == '2' && cur <= '6')) { //由前一个字符和当前字符所构成的数字，值必须要在 1 到 26 之间，否则无法进行解码
            count += decode(cs, index - 2);
        }
        return count;
    }

    public int numDecodings1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        return decode1(chars, chars.length - 1);
    }

    private int decode1(char[] chars, int index) {
        if (index <= 0) {
            return 1;
        }
        char current = chars[index];
        char prev = chars[index - 1];
        int count = 0;
        if (current > '0') {
            count = decode1(chars, index - 1);
        }
        if (prev == '1' || (prev == '2' && current <= '6')) {
            count += decode1(chars, index - 2);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
