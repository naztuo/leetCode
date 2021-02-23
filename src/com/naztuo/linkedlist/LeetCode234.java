package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

/**
 * 回文链表，可用快慢指针、递归、栈解决
 */
public class LeetCode234 {
    /**
     * 解法1
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //利用快慢指针
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast == null,则说明为奇数个，slow向前移一个
        if(fast != null) {
            slow = slow.next;
        }

        ListNode prev = null;
        while(slow != null) {
            ListNode cur = slow.next;
            slow.next = prev;
            prev = slow;
            slow = cur;
        }

        fast = head;
        while(prev != null) {
            if(prev.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
