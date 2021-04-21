package com.naztuo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package com.naztuo.tree
 * @Description: n叉树的后续遍历
 * @Author zhaoxiao x5445
 * @Date 2021-03-31 15:29
 * @Version 1.0
 */
public class LeetCode590 {

    public List<Integer> houxuBianli(Node node) {
        List<Integer> res = new ArrayList<>();
        bianli(node, res);
        return res;
    }
    //方法1 递归
    private void bianli(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                bianli(child, res);
            }
        }
        res.add(node.val);
    }

    //方法2 遍历
    public List<Integer> houxuBianli2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        stack.add(root);
        while(!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.addFirst(node.val);
            for(Node item : node.children) {
                if(item != null) {
                    stack.add(item);
                }
            }
        }
        return res;


    }
}
