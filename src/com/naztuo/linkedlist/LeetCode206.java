package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

public class LeetCode206 {

    /**
     * 解法1 双指针迭代
     * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
     * 第二个指针 cur 指向 head，然后不断遍历 cur。
     * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
     * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
     *
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
