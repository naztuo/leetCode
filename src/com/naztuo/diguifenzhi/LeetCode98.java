package com.naztuo.diguifenzhi;

import com.naztuo.tree.TreeNode;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 验证二叉树是否为二叉搜素树
 * @Author zhaoxiao x5445
 * @Date 2021-04-06 14:49
 * @Version 1.0
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, int lower , int upper) {
        if(node == null) {
            return true;
        }
        if(node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left,lower,node.val) && isValidBST(node.right,node.val,upper);
    }
}
