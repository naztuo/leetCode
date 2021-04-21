package com.naztuo.huishuo;

import java.util.*;

/**
 * @Package com.naztuo.huishuo
 * @Description: TODO
 * @Author zhaoxiao x5445
 * @Date 2021-04-09 10:47
 * @Version 1.0
 */
public class LeetCode39 {

        List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯加深度优先搜索
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int length = candidates.length;
        if (length == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, length, target, path);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param length     冗余变量，是candidates里面的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根节点到叶子节点的路径，是一个栈
     */
    private void dfs(int[] candidates, int begin, int length, int target, Deque<Integer> path) {
        if (target < 0) { //target为负数不产生新的孩子节点
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, i, length, target - candidates[i], path);
            path.removeLast(); //状态重置
        }
    }

    /**
     *回溯深度优先搜索加剪枝
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        if (length == 0) {
            return res;
        }
        //排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(candidates, 0, length, target, path, res);
        return res;
    }

    private void dfs2(int[] candidates, int begin, int length, int target, Deque<Integer> path, List<List<Integer>> res) {
        //由于进入更深层的时候，小于0的部分被剪枝，因此递归条件值只判断等于0的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs2(candidates, i, length, target-candidates[i], path, res);
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        System.out.println(1 << 1);
        System.out.println(new LeetCode39().combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }


}
