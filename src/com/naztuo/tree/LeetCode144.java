package com.naztuo.tree;

import com.naztuo.linkedlist.bean.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package com.naztuo.tree
 * @Description: 二叉树前序遍历
 * @Author zhaoxiao x5445
 * @Date 2021-03-31 14:33
 * @Version 1.0
 */
public class LeetCode144 {
    /**
     * 方法1 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);  //中
        preorder(root.left, res); //左
        preorder(root.right, res); //右
    }

    /**
     * 方法2 遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

}
