package com.cm.special_enterprise.de.leecode;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Test02 {

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = head.next;
        }
        return pre;
    }

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalance(root.left) && isBalance(root.right)) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return  isEqual(root.left, root.right);
    }

    public static boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null || right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

    public TreeNode lowCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        findPath(root, p, path1);
        findPath(root, q, path2);
        return getNode(path1, path2);
    }

    private TreeNode getNode(Stack<TreeNode> path1, Stack<TreeNode> path2) {
        while (path1.size() > path2.size()) {
            path1.pop();
        }
        while (path2.size() > path1.size()) {
            path2.pop();
        }
        while (!path1.isEmpty()) {
            TreeNode node1 = path1.pop();
            TreeNode node2 = path2.pop();
            if (node1 == node2) {
                return node1;
            }

        }
        return null;
    }

    private boolean  findPath(TreeNode root, TreeNode node, Stack<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.push(root);
        if (root.val == node.val) {
            return true;
        }
        if (findPath(root.left,node, path)){
            return true;
        }
        if (findPath(root.right, node, path)) {
            return true;
        }
        path.pop();
        return false;
    }

    public class Solution {
        //????????????????????????
        ListNode merge(ListNode pHead1, ListNode pHead2) {
            //?????????????????????????????????????????????
            if(pHead1 == null)
                return pHead2;
            if(pHead2 == null)
                return pHead1;
            //???????????????
            ListNode head = new ListNode(0);
            ListNode cur = head;
            //???????????????????????????
            while(pHead1 != null && pHead2 != null){
                //?????????????????????
                if(pHead1.val <= pHead2.val){
                    cur.next = pHead1;
                    //????????????????????????
                    pHead1 = pHead1.next;
                }else{
                    cur.next = pHead2;
                    //????????????????????????
                    pHead2 = pHead2.next;
                }
                //????????????
                cur = cur.next;
            }
            //??????????????????????????????????????????
            if(pHead1 != null)
                cur.next = pHead1;
            else
                cur.next = pHead2;
            //?????????????????????
            return head.next;
        }

        public ListNode sortInList (ListNode head) {
            //????????????????????????????????????????????????????????????
            if(head == null || head.next == null)
                return head;
            ListNode left = head;
            ListNode mid = head.next;
            ListNode right = head.next.next;
            //???????????????????????????????????????????????????????????????????????????
            while(right != null && right.next != null){
                left = left.next;
                mid = mid.next;
                right = right.next.next;
            }
            //???????????????????????????????????????????????????????????????
            left.next = null;
            //?????????????????????????????????????????????
            return merge(sortInList(head), sortInList(mid));
        }
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;

            }
            cur = cur.next;
        }
        if (head1 != null)
            cur.next = head1;
        else
            cur.next = head2;

        return head.next;
    }

    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        left.next = null;
        return merge(sortInList(head), sortInList(mid));
    }

    public static ListNode reverse2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode cur_next = head.next;
            head.next = pre;
            pre = head;
            head = cur_next;
        }
        return pre;
    }




    public static ListNode addInList (ListNode head1, ListNode head2) {
        ListNode node1 = reverse2(head1);
        ListNode node2 = reverse2(head2);
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        int temp = 0;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode((node1.val + node2.val+temp) % 10);
            temp = (node1.val + node2.val) / 10;
            cur.next = node;
            cur = node;
            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1 != null) {
            ListNode node = new ListNode((node1.val + temp) % 10);
            temp = (node1.val + temp) / 10;
            cur.next = node;
            cur = node;
            node1 = node1.next;
        }
        while (node2 != null) {
            ListNode node = new ListNode((node2.val + temp) % 10);
            temp = (node2.val + temp) / 10;
            cur.next = node;
            cur = node;
            node2 = node2.next;
        }
        if (temp == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        ListNode target = reverse2(dummyNode.next);

        return target;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        double a = 1;
        double b =8;
        System.out.println(getDouble(a, b, 2));
    }

    public static String getDouble(double a, double b, int s) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(s);
        double temp = 1;
        for (int i = 0; i <= s; i++) {
            temp *= 10;
        }
        return format.format((a / b) +  5 / temp);
    }


    public static ListNode sortList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre_pre = dummyNode;
        ListNode pre =pre_pre.next;
        while (pre != null) {
            boolean flag = true;
            ListNode cur_pre = pre_pre.next;
            ListNode cur = pre.next;
            while (cur != null) {
                if (cur.val < pre.val) {

                }
                cur_pre = cur_pre.next;
                cur = cur.next;
            }
            pre_pre = pre_pre.next;
            pre = pre.next;
            if (flag) {
                return dummyNode.next;
            }
        }
        return dummyNode.next;
    }


    public class Solution3 {
        public ListNode oddEvenList (ListNode head) {
            //?????????????????????????????????
            if(head == null)
                return head;
            //even??????????????????????????????????????????
            ListNode even = head.next;
            //odd???????????????????????????
            ListNode odd = head;
            //??????even??????
            ListNode evenhead = even;
            while(even != null && even.next != null){
                //odd??????even???????????????????????????
                odd.next = even.next;
                //odd????????????????????????
                odd = odd.next;
                //even????????????????????????????????????????????????
                even.next = odd.next;
                //even????????????????????????
                even = even.next;
            }
            //even????????????odd??????
            odd.next = evenhead;
            return head;
        }

        public  ListNode oddEvenList1 (ListNode head){
            if (head == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while (even!=null&&even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }

    }


}
