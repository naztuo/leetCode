package com.naztuo.stack;

import java.util.*;

/**
 * @Package com.naztuo.stack
 * @Description: TODO
 * @Author zhaoxiao x5445
 * @Date 2021-03-15 16:30
 * @Version 1.0
 */
public class LeetCode1441 {
    private static final String PUSH = "Push";

    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        Deque<Integer> list = new LinkedList<>();
        List<String> result = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if(index >= target.length) {
                break;
            }
            list.push(i);
            result.add(PUSH);
            if (target[index] > i) {
                list.pop();
                result.add(POP);
            } else {
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1441().buildArray(new int[]{1,3,5,6,7},6));
    }
}
