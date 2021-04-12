package com.naztuo.diguifenzhi;

import com.naztuo.linkedlist.bean.ListNode;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 合并两个有序链表
 * @Author zhaoxiao x5445
 * @Date 2021-03-19 15:21
 * @Version 1.0
 */
public class LeetCode21 {


    public ListNode mergeTwoNode(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode header = new ListNode();
        ListNode current = header;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        if(a != null) {
            current.next = a;
        }
        if(b != null) {
            current.next = b;
        }
        return header.next;
    }

    /**
     * 递归,每次判断a和b的头结点哪个更小，然后较小节点的next指针指向其余节点的合并结果
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeTwoNode1(ListNode a, ListNode b) {
        if(a == null) {
            return b;
        } else if(b== null) {
            return a;
        } else if(a.val <b.val) {
            a.next = mergeTwoNode1(a.next,b);
            return a;
        } else {
            b.next = mergeTwoNode1(a,b.next);
            return b;
        }
    }


}
