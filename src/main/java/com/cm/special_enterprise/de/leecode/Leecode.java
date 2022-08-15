package com.cm.special_enterprise.de.leecode;

import java.util.Stack;

public class Leecode {

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
        System.out.println(reverse2(node1));
    }

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack == null) {
            return null;
        }
        ListNode node = stack.pop();
        ListNode dummy = node;//头节点   返回值用
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        node.next = null;
        return dummy;
    }


    public static ListNode reverse2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
        return pre;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode cur_next;
        for (int i = 0; i <n-m; i++) {
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = cur;
            pre.next = cur_next;
        }
        return dummyNode.next;
    }
}
