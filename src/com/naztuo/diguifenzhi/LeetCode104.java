package com.naztuo.diguifenzhi;

import com.naztuo.tree.LeetCode236;
import com.naztuo.tree.TreeNode;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 二叉树的最大深度
 * @Author zhaoxiao x5445
 * @Date 2021-03-18 15:48
 * @Version 1.0
 */
public class LeetCode104 {

    public int maxDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return maxDepthOfTree(node,1);
    }

    private int maxDepthOfTree(TreeNode node, int currentDepth) {
        if(node == null) {
            return currentDepth -1 ;
        }
        if (node != null && node.left == null && node.right == null) {
            return currentDepth;
        }
        int leftDepth = maxDepthOfTree(node.left, currentDepth + 1);
        int rightDepth = maxDepthOfTree(node.right, currentDepth + 1);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }


    public int maxDepth1(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return maxDepthOfTree1(node,1);
    }

    private int maxDepthOfTree1(TreeNode node, int currentDepth) {
        if(node == null) {
            return currentDepth - 1;
        }
        if(node != null && node.left == null && node.right == null) {
            return currentDepth;
        }
        int leftDepth = maxDepthOfTree1(node.left,currentDepth +1 ) ;
        int rightDepth = maxDepthOfTree1(node.right,currentDepth + 1);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }


    public static void main(String[] args) {

        String root = "[3,5,7,9,11,13,null]";
        TreeNode rootTree = TreeNode.mkTree(root);

        System.out.println(new LeetCode104().maxDepth(rootTree));
    }
}
