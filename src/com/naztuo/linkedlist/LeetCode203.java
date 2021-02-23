package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

/**
 * 删除列表中一个元素，并返回头结点
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(0,head);
        ListNode current = header;
        while(current.next != null) {
            if(current.next.val ==val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return header.next;
    }
}
