package com.naztuo.stack;

import java.util.LinkedList;

/**
 * @Package com.naztuo.stack
 * @Description: 文件夹操作日志搜集器
 * @Author zhaoxiao x5445
 * @Date 2021-03-15 15:45
 * @Version 1.0
 */
public class LeetCode1598 {
    /**
     * 其实感觉这个题目不用栈也很好解决，而且可能更简单
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        int ans = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) ans = Math.max(0, ans - 1);
            else if(!logs[i].equals("./")) ans++;
        }
        return ans;
    }

}
