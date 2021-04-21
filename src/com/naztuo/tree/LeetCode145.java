package com.naztuo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package com.naztuo.tree
 * @Description: 后续遍历
 * @Author zhaoxiao x5445
 * @Date 2021-03-31 16:17
 * @Version 1.0
 */
public class LeetCode145 {

    public List<Integer> houxuBianli(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bianli(root, res);
        return res;
    }

    private void bianli(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        bianli(root.left, res);    //左
        bianli(root.right, res);  // 右
        res.add(root.val);  //中
    }


    public List<Integer> houxuBianli2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) { //一直往下探
                stack.push(root);
                root = root.left;
            }
            if(root.right == null || root.right == prev) { //如果没有右节点
                res.add(root.val); //添加右节点
                prev = root;
                root = null;
            } else {  //有的话，探右节点
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
