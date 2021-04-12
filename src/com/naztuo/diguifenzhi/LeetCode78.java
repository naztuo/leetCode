package com.naztuo.diguifenzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 子集
 * @Author zhaoxiao x5445
 * @Date 2021-04-07 10:26
 * @Version 1.0
 */
public class LeetCode78 {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }


    public List<List<Integer>> subsets1(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            //当数组走完时，加到结果中，这里之所以要new ArrayList，是因为不new的话，则一直用的同一个arrayList,同一个引用
            ans.add(new ArrayList<>(t));
            return;
        }
        //走到的地方加入的情况
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        //走到的地方不加入的情况
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode78().subsets1(new int[]{1, 2, 3}));
    }


}
