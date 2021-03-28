package com.naztuo.treenode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode98 {

    /**
     * 解法1 递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if(node == null) {
            return true;
        }
        //注意有等于
        if(node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left,lower,node.val) && isValidBST(node.right,node.val,upper);
    }

    long pre = Long.MIN_VALUE;

    /**
     * 解法2 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }



}
