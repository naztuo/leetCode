package com.naztuo.linkedlist;

import com.naztuo.linkedlist.bean.ListNode;

/**
 * todo 此题还有更好的解法
 */
public class LeetCode23 {

    /**
     * 解法1 顺序合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode header = new ListNode(-1);
        ListNode current = header;
        if(lists.length == 0) {
            return header.next;
        }
        int val = 0;
        int index = 0;
        while(current != null) {
            ListNode temp = null;
            for(int j = 0; j < lists.length;j++) {
                if(lists[j] != null) {
                    val = lists[j].val;
                    index = j;
                    temp = lists[j];
                    break;
                }
            }
            if(temp == null) {
                return header.next;
            }
            for(int k = 0; k< lists.length; k++) {

                if(lists[k] != null && lists[k].val < val) {
                    index = k;
                    val = lists[k].val;
                    temp = lists[k];
                }
            }
            current.next = temp;
            current = current.next;
            if(lists[index] != null && lists[index].next != null) {
                lists[index] = lists[index].next;
            } else {
                lists[index] = null;
            }

        }
        return header.next;
    }

}
