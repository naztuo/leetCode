package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断数组是否有环
 */
public class LeetCode141 {

    /**
     * 解法1 使用快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        // Set<ListNode> set = new HashSet<>();
        if(head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast !=slow) {
            if(fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 解法2 使用set判重
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if(head == null) {
            return false;
        }
        set.add(head);
        while(head.next != null) {
            head = head.next;
            //如果加入失败，说明已经存在
            if(!set.add(head)) {
                return true;
            }
        }
        return false;

    }
}
