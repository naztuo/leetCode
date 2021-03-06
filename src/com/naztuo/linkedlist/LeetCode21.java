package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

public class LeetCode21 {

    /**
     * 方法1 硬比较
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode newNode = header;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val > l2.val) {

                    newNode.next = l2;

                    l2 = l2.next;
                } else {
                    newNode.next = l1;
                    l1 = l1.next;
                }
            } else if(l2 == null) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode.next.next = null;
        }
        return header.next;
    }

    /**
     * 方法1的优化版本
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * 解法2 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l2 == null) {
            return l1;
        }
        if(l1 == null) {
            return l2;
        }

        if(l1.val >l2.val) {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }

    }
}
