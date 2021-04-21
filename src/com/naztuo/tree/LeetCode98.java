package com.naztuo.tree;



public class LeetCode98 {

    /**
     *解法1 递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode node, long lower, long upper) {
        if(node == null) {
            return true;
        }
        if(node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST1(node.left,lower,node.val) && isValidBST1(node.right,node.val,upper);
    }


    long pre = Long.MIN_VALUE;

    /**
     * 解法2 递归判断前一个节点与后一个节点的大小
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if(root == null) {
            return true;
        }
        //访问左子树
        if(!isValidBST1(root.left)) {
            return false;
        }
        //访问当前节点；如果当前节点小于等于中序遍历的前一个节点，说明不满足BST;否则继续遍历
        if(root.val <= pre) {
            return false;
        }

        pre = root.val;

        //遍历右子树
        return isValidBST1(root.right);

    }

}
