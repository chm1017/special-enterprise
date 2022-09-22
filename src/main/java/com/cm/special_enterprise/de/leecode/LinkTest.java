package com.cm.special_enterprise.de.leecode;

import cn.hutool.core.net.Ipv4Util;
import com.alibaba.druid.sql.visitor.functions.Char;
import com.cm.special_enterprise.de.Test01;
import com.cm.special_enterprise.de.leecode.ListNode;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class LinkTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(reverseBetween2(head, 1, 4));
//        System.out.println(delNode(head, 6));
//        System.out.println(removeElements(head, 2));

    }

    public static ListNode reverseBetween2 (ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode cur_next ;
        for (int i = 0; i < n - m; i++) {
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return dummyNode.next;
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // 课号 和 对应的入度
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        HashMap<Integer, List<Integer>> adj = new HashMap<>();//邻接表    依赖当前课程的后续课程
        for (int[] prerequisite : prerequisites) {
            int next = prerequisite[0];
            int cur = prerequisite[1];
            inDegree.put(next,inDegree.get(next) + 1);
            if (!adj.containsKey(cur)) {
                adj.put(cur, new ArrayList<Integer>());
            }
            adj.get(cur).add(next);
        }
        Queue<Integer> q = new LinkedList<>();
        for (Integer key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (!adj.containsKey(cur)) {
                continue;
            }
            List<Integer> successorList = adj.get(cur);
            for (Integer k : successorList) {
                inDegree.put(k, inDegree.get(k - 1));
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }
        for (Integer key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;


    }

    public boolean canSuccess(int numCourses, int[][] prerequisites){
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
//        链接表
        HashMap<Integer, List<Integer>> jds = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int next = prerequisite[0];
            int cur = prerequisite[1];
            inDegree.put(next, inDegree.get(next) + 1);
            if (!jds.containsKey(cur)) {
                jds.put(cur, new ArrayList<Integer>());
            }
            jds.get(cur).add(next);
        }
//        选取入度为0 的节点  入队列
        Queue<Integer> q = new LinkedList<>();
        for (Integer key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (!jds.containsKey(cur)) {
                continue;
            }
            List<Integer> Sussessor = jds.get(cur);
            for (Integer key : Sussessor) {
                inDegree.put(key, inDegree.get(key) - 1);
                if (inDegree.get(key) == 0) {
                    q.offer(key);
                }
            }
        }
        for (Integer key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
//        链接表
        HashMap<Integer, List<Integer>> jds = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int next = prerequisite[0];
            int cur = prerequisite[1];
            inDegree.put(next, inDegree.get(next) + 1);
            if (!jds.containsKey(cur)) {
                jds.put(cur, new ArrayList<Integer>());
            }
            jds.get(cur).add(next);
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> target = new ArrayList<Integer>();

        for (Integer key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
                target.add(key);
            }
        }
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (!jds.containsKey(cur)) {
                continue;
            }
            List<Integer> Sussessor = jds.get(cur);
            for (Integer key : Sussessor) {
                inDegree.put(key, inDegree.get(key) - 1);
                if (inDegree.get(key) == 0) {
                    q.offer(key);
                    target.add(key);
                }
            }
        }



        int[] i = new int[numCourses];
        for (int j = 0; j < target.size(); j++) {
            i[j] = target.get(j);
        }
        return i;
    }

    static class Trie {
         private  ArrayList<String> list;


        public Trie() {
            this.list = new ArrayList<>();
        }

        public void insert(String word) {
            list.add(word);
        }

        public boolean search(String word) {
            for (String s : list) {
                if (word.equals(s)) {
                     return  true;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            for (String s : list) {
                if (s.startsWith(prefix)) {
                    return true;
                }
            }
            return false;

        }
    }
    public int rob(int[] nums) {
        int len = nums.length;
        if (nums==null&&len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public int getMaxRob(int[] nums) {
        int len = nums.length;
        if (nums == null && nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }



    public int rob(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start + 1],first);
        for (int i = start+2; i <= end; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }
        return second;
    }

    public String shortestPalindrome(String s) {
        StringBuilder b = new StringBuilder(s);
        StringBuilder reverse = b.reverse();
        int length = reverse.length();

        return "";
        
    }


    public int lengthOfLongestSubstring(String s) {

        return 0;

    }
    public boolean isHuiWen(String s) {
        if (s.equals(new StringBuilder(s).reverse())) {
            return true;
        }
        return false;
    }



    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <=n ; i++) {
            int temp = second;
            second = second + first;
            first = temp;
        }
        return second;
    }

}
