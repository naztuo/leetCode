package com.naztuo.linkedlist;


import com.naztuo.linkedlist.bean.ListNode;

public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode header1 = new ListNode(0,head);
        ListNode current1= header1;
        ListNode header2 = new ListNode();
        ListNode current2 = header2;
        while(head != null) {
            if(head.val < x) {
                current1.next = head;
                current1 = current1.next;
                head = head.next;
                //设置为null,防止链表出现环
                current1.next = null;
            } else {
                current2.next = head;
                current2 = current2.next;
                head = head.next;
                //设置为null,防止链表出现环
                current2.next = null;
            }

        }
        current1.next = header2.next;
        return header1.next;
    }
}
