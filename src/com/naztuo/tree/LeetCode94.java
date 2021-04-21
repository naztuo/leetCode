package com.naztuo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package com.naztuo.tree
 * @Description: 二叉树中序遍历
 * @Author zhaoxiao x5445
 * @Date 2021-03-31 13:42
 * @Version 1.0
 */
public class LeetCode94 {
    /**
     * 方法1 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);  //左
        res.add(root.val);       //中
        inorder(root.right, res);  //右
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {  //一直遍历到最底层
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
