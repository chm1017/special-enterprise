package com.cm.special_enterprise.de.leecode;

import cn.hutool.core.net.Ipv4Util;
import com.alibaba.druid.sql.visitor.functions.Char;
import com.cm.special_enterprise.de.Test01;
import com.cm.special_enterprise.de.leecode.ListNode;

import java.util.*;

public class LinkTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        System.out.println(reverseBetween(head, 2, 3));
//        System.out.println(delNode(head, 6));
        System.out.println(removeElements(head, 2));

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }

    public static ListNode reverseLinkList(ListNode head) {
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

    public static ListNode reverseBetween(ListNode head, int start, int end) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < start - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = start; i <end ; i++) {
            ListNode cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return pre;
    }

    public class Solution {
        public ListNode removeNthFromEnd (ListNode head, int n) {
            //添加表头
            ListNode res = new ListNode(-1);
            res.next = head;
            //当前节点
            ListNode cur = head;
            //前序节点
            ListNode pre = res;
            ListNode fast = head;
            //快指针先行n步
            while(n != 0){
                fast = fast.next;
                n--;
            }
            //快慢指针同步，快指针到达末尾，慢指针就到了倒数第n个位置
            while(fast != null){
                fast = fast.next;
                pre = cur;
                cur = cur.next;
            }
            //删除该位置的节点
            pre.next = cur.next;
            //返回去掉头
            return res.next;
        }
    }


    public static ListNode delNode(ListNode head,int n ) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        ListNode fast = head;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;

        return res.next;
    }

        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            //排除特殊情况
            if(k == 0 || input.length == 0)
                return res;
            //大根堆
            PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2)->o2.compareTo(o1));
            //构建一个k个大小的堆
            for(int i = 0; i < k; i++)
                q.offer(input[i]);
            for(int i = k; i < input.length; i++){
                //较小元素入堆
                if(q.peek() > input[i]){
                    q.poll();
                    q.offer(input[i]);
                }
            }
            //堆中元素取出入数组
            for(int i = 0; i < k; i++)
                res.add(q.poll());
            return res;
        }


    static  boolean isIPv4(String ip) {
        if (ip.indexOf('.')==-1) {
            return false;
        }
        String[] s = ip.split("\\.");
        if (s.length != 4) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() == 0) {
                return false;
            }
            if (s[i].length() < 0 || s[i].length() > 3 || (s[i].charAt(0) == '0' && s[i].length() != 1)) {
                return false;
            }
            int num = 0;
            for (int j = 0; j < s[i].length(); j++) {
                char c = s[i].charAt(j);
                if (c < '0' || c > '9') {
                    return false;
                }
                num = num * 10 + (c - '0');
                if (num < 0 || num > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    static  boolean isIPv6(String ip) {
        if (ip.indexOf('.') == -1) {
            return false;
        }
        String[] s = ip.split("\\.");
        if (s.length != 8) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() == 0 || s[i].length() > 4) {
                return false;
            }
            for (int j = 0; j < s[i].length(); j++) {
                char c = s[i].charAt(j);
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String sovle(String ip) {
        if (isIPv4(ip)) {
            return "IPv4";}
        if (isIPv6(ip)) {
            return "IPv6";
        }
        return "neither";


    }

    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i <n; i++) {
            if (isPrimes(i)) {
                ans++;
            }
        }
        return ans;

    }

    public boolean isPrimes(int x) {
        for (int i = 2; i *i<=x ; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(value)) {
                    return false;
                }
            } else {
                map.put(key, value);
            }
        }
        if (true) {
            HashMap<Character, Character> map2 = new HashMap<>();
            int len2 = s.length();
            for (int i = 0; i < len2; i++) {
                char key = t.charAt(i);
                char value = s.charAt(i);
                if (map2.containsKey(key)) {
                    if (!map2.get(key).equals(value)) {
                        return false;
                    }
                } else {
                    map2.put(key, value);
                }
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode cur_next = head.next;
            head.next = pre;
            pre = head;
            head = cur_next;
        }
        return pre;
    }




}
