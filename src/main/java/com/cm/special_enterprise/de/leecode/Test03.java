package com.cm.special_enterprise.de.leecode;

import com.graphbuilder.math.func.LnFunction;
import org.checkerframework.checker.units.qual.min;
import org.springframework.boot.rsocket.server.RSocketServer;
import sun.rmi.transport.Transport;

import java.util.List;
import java.util.Stack;

public class Test03 {

    public ListNode oddEvenSort(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode delRepetit(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            pre.next = null;
            if (cur.val != pre.val) {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(delRepetit2(node1));
    }

    public static ListNode delRepetit2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;
        ListNode low = head;
        ListNode mid = low.next;
        if (mid==null||low.val != mid.val) {
            node.next = low;
            node = node.next;
        }
        while (mid != null  ) {
            if (mid.next == null) {
                if (low.val != mid.val) {
                    node.next = mid;
                } else {
                    node.next = null;
                }
                return dummyNode.next;
            }
            if (low.val != mid.val && mid.val != mid.next.val) {
                node.next = mid;
                node = node.next;
            }
            low = low.next;
            mid = mid.next;
        }
        return dummyNode.next;
    }


    public int search (int[] nums, int target) {
        int max = nums.length-1;
        int min = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return -1;
    }

    public class Solution {
        public boolean Find(int target, int [][] array) {
            //优先判断特殊
            if(array.length == 0)
                return false;
            int n = array.length;//行高
            if(array[0].length == 0)
                return false;
            int m = array[0].length;//列宽
            //从最左下角的元素开始往左或往上
            for(int i = n - 1, j = 0; i >= 0 && j < m; ){
                //元素较大，往上走
                if(array[i][j] > target)
                    i--;
                    //元素较小，往右走
                else if(array[i][j] < target)
                    j++;
                else
                    return true;
            }
            return false;
        }
    }

    public boolean find2(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        int n = array.length;
        if (array[0].length == 0) {
            return false;
        }
        int m = array[0].length;
        for (int i = n - 1, j = 0; i > 0 && j < m; ) {
            if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            }
            else
                return true;
        }

        return false;


    }




}
