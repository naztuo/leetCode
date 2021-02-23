package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode header = new ListNode(0,head);
        ListNode current = header;
        ListNode ouHeader = new ListNode(0);
        ListNode ouCurrent = ouHeader;
        while(current.next != null) {
            current = current.next;
            //赋给偶数链表
            ouCurrent.next = current.next;
            ouCurrent = ouCurrent.next;
            if(current.next != null) {
                current.next = current.next.next;
            } else {
                break;
            }
        }
        current.next = ouCurrent.next;
        return header;
    }


    /**
     * 更好的解法，逻辑相同，但是代码更清晰
     */
    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
