package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

import javax.xml.soap.Node;

public class LeetCode2 {

    /**
     * 解法1 将长度较短的链表在末尾补零使得两个连表长度相等，再一个一个元素对其相加（考虑进位）
     *
     * 获取两个链表所对应的长度
     * 在较短的链表末尾补零
     * 对齐相加考虑进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode newNode = header;
        int full = 0;
        while(l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + full;
            full = sum /10;
            int nodeSum = sum %10;
            newNode.next = new ListNode(nodeSum);
            newNode = newNode.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(full == 1) {
            newNode.next = new ListNode(0);
        }
        return header.next;
    }

    public static void main(String[] args) {
        Long a = 9223372036854775807L;
        Long b = 465L;
        System.out.println(10/10);
    }
}
