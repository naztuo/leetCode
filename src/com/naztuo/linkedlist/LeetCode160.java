package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode160 {

    /**
     * 解法1 使用set保存链表1，再遍历链表2,如果存在相同的元素，则说明存在相交的情况
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(headA);
        while(headA.next != null) {
            headA = headA.next;
            set.add(headA);
        }
        if(!set.add(headB)) {
            return headB;
        }
        while(headB.next !=null) {
            headB = headB.next;
            if(!set.add(headB)) {
                return headB;
            }
        }
        return null;
    }

    /**
     * 解法2 使用双指针
     * 如果两个链表相交，那么相交点之后的长度是相同的
     *
     * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
     * 为此，我们必须消除两个链表的长度差
     *
     * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 如果 pA 到了末尾，则 pA = headB 继续遍历
     * 如果 pB 到了末尾，则 pB = headA 继续遍历
     * 比较长的链表指针指向较短链表head时，长度差就消除了
     * 如此，只需要将最短链表遍历两次即可找到位置
     *
     * 作者：reals
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b) {
            a = a.next;
            b = b.next;
            if(a == null && b == null) {
                return null;
            }
            if(a == null) {
                a = headB;
            }
            if(b == null) {
                b = headA;
            }
        }
        return a;
    }

    /**
     * 最优解
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
