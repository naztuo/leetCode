package com.naztuo.tree;

/**
 * @Package com.naztuo.tree
 * @Description: 最近公共祖先
 * @Author zhaoxiao x5445
 * @Date 2021-03-16 16:22
 * @Version 1.0
 */
public class LeetCode236 {

    public TreeNode losetParentNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = losetParentNode(root.left, p, q);
        TreeNode right = losetParentNode(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public TreeNode losetParentNode1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = losetParentNode1(root.left, p, q);
        TreeNode right = losetParentNode1(root.right, p, q);
        System.out.println("left:" + (left == null ? null : left.val) + ",        right:" + (right == null ? null : right.val));
        //如果左右子节点都不为空，则返回当前节点
        if (left != null && right != null) {
            return root;
        }
        //left为空就返回right,right为空就返回left
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        String root = "[3,5,1,6,2,0,8,null,null,7,4]";
        String root1 = "[5,6,2,null,null,7,4]";
        String root2 = "[1,0,8]";
        TreeNode rootTree = TreeNode.mkTree(root);

        System.out.println(new LeetCode236().losetParentNode1(rootTree, rootTree.left, rootTree.right.right));
    }


}
