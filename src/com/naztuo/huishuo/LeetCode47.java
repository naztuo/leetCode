package com.naztuo.huishuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列2
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, nums, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] nums, ArrayList<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                //剪枝，当当前元素与前一个元素相同，且前一个元素还没使用过的时候，我们要剪枝
                if(i > 0 && nums[i-1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                used[i] = true;
                dfs(list, nums, temp,used);
                used[i]= false;
                temp.remove(temp.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new LeetCode47().permuteUnique(nums));
    }
}
