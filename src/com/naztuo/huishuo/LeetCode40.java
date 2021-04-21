package com.naztuo.huishuo;

import java.util.*;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, 0, target, new ArrayList<>(), new boolean[candidates.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int index, int target,
                     ArrayList<Integer> temp, boolean[] used) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(!used[i]) {
                //剪枝，当当前元素与前一个元素相同，且前一个元素还没使用过的时候，我们要剪枝
                if(i > 0 && candidates[i-1] == candidates[i] && !used[i - 1]) {
                    continue;
                }
                int newtarget = target - candidates[i];
                if (newtarget < 0) {
                    break;
                }

                temp.add(candidates[i]);
                used[i] = true;
                dfs(res,candidates,i +1 , newtarget,temp,used);
                used[i] = false;
                temp.remove(temp.size() -1);
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode40().combinationSum2(new int[]{2,2,2,3, 6, 7}, 7));
    }
}
