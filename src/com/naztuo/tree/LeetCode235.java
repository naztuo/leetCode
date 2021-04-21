package com.naztuo.tree;

/**
 * @Package com.naztuo.tree
 * @Description: 二叉搜索树寻找最近公共节点
 * @Author zhaoxiao x5445  todo
 * @Date 2021-03-17 17:31
 * @Version 1.0
 */
public class LeetCode235 {

    public TreeNode losetParentNode1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        //替换之后，保证p较小，q较大
        if(p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q= temp;
        }
        while(!(root.val > p.val && root.val < q.val)) {
            if(root.val < p.val) {
                root = root.right;
            } else if(root.val > q.val) {
                root = root.left;
            }
        }
        return root;
    }

 //
}
