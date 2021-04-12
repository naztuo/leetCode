package com.naztuo.diguifenzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 括号生成
 * @Author zhaoxiao x5445
 * @Date 2021-04-02 14:01
 * @Version 1.0
 */
public class LeetCode22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            return res;
        }
        //进行深度优先遍历，搜索可能的结果
        getParenthesis(n,n,"");
        return res;
    }

    private void getParenthesis(int left, int right, String str) {
        if(left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if(left > right) {
            return;
        }
        if(left > 0) {
            getParenthesis(left -1 ,right, str + "(");
        }
        if(right > 0) {
            getParenthesis(left ,right - 1, str + ")");
        }
    }
}
