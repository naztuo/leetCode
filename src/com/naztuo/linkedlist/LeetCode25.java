package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

public class LeetCode25 {
    //todo
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode header = new ListNode(0,head);
        ListNode current = header;
        int sum = 0;
        while(current.next != null) {
            current = current.next;
            sum ++;
        }
        if(sum <=k) {
            return head;
        }
        current = header.next;
        int num = 0;
        ListNode start = null;
//        ListNode end = null;
        ListNode prev = null;
        while(current != null) {
            if(num / k < sum /k) {
                start = current;
                for (int i = 0; i < k; i++) {
                    start = start.next;
                }
                ListNode temp = current.next;
                if(num % k == 0) {
                    prev = start;
                }
                current.next = prev;
                prev = current;
                current = temp;
                num ++;
            } else {
                break;
            }

//            if(num / k < sum /k) {
//                if(num % k == 0 ) {
//                    end = current;
//                }
//                if((num + 1) %k == 0) {
//                    start = current.next;
//                }
//                ListNode temp = current.next;
//                current.next = prev;
//                prev = current;
//                current = temp;
//                if((num + 1) %k == 0) {
//                    end.next = start;
//                }
//                num++;
//            } else {
//                break;
//            }

        }
        return header.next;
    }

    public static void main(String[] args) {
        System.out.println(1/3);
        System.out.println(2/3);
        System.out.println(3/3);
        System.out.println(4/3);
        System.out.println(5/3);
    }
}
