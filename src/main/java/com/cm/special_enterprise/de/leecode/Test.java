package com.cm.special_enterprise.de.leecode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        System.out.println(reverse(node1));
        System.out.println(betweenReverse(node1, 2, 4));

    }

    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur!= null) {
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
        return pre;
    }

    public static ListNode betweenReverse(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode cur_next;
        for (int i = 0; i < n - m; i++) {
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = cur;
            pre.next = cur_next;
            cur = pre.next;
        }
        return dummyNode.next;
    }
}
