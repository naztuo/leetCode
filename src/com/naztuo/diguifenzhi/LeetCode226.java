package com.naztuo.diguifenzhi;

import com.naztuo.tree.LeetCode236;
import com.naztuo.tree.TreeNode;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 翻转二叉树
 * @Author zhaoxiao x5445
 * @Date 2021-04-06 14:21
 * @Version 1.0
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) { //终止条件
            return null;
        }
        //左右子树交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归交换左子树
        invertTree(root.left);
        //递归交换右子树
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        String root = "[1,2,3,4,5,6,7]";
        TreeNode rootTree = TreeNode.mkTree(root);

        System.out.println(new LeetCode226().invertTree(rootTree));
    }
}
