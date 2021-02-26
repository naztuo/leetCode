package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

public class LeetCode92 {
    /**
     * todo
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode header = new ListNode(0,head);
        ListNode current = header;
        int i =0;
        ListNode prev = null;
        ListNode start = null;
        while(current!= null) {
            i++;
            if(i == left - 1) {
                start = current;
                for (int j = i; j < right; j++) {
                    start = start.next;
                }
                ListNode temp = current.next;
                current.next = start;
                prev = current;
                current = temp;
            } else {

            }

        }
        return null;
    }
}
