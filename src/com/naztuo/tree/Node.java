package com.naztuo.tree;

import java.util.List;

/**
 * @Package com.naztuo.tree
 * @Description: TODO
 * @Author zhaoxiao x5445
 * @Date 2021-03-31 15:19
 * @Version 1.0
 */
public class Node {
    public int val;

    public List<Node> children;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
