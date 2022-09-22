package com.cm.special_enterprise.de.leecode;

import com.graphbuilder.math.func.LnFunction;
import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.apache.coyote.http11.filters.IdentityOutputFilter;
import org.checkerframework.checker.units.qual.A;

import java.util.*;
//collection list set   lsit - >vector（线程安全                                           ） arraylist linkedlist;   set -> hashset treeset     map -> hashmap hashtable（线程安全）  treemap

public class Practice {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        node1.next = node3;
//        node3.next = node5;
//        node5.next = node4;
//        node4.next = node2;
//        node2.next = node3;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(removeNthFromEnd(node1,2));

    }

    public int rob (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0], second = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }
        return second;
    }

        public int[] postorderTraversal (TreeNode root) {
            //添加遍历结果的数组
            List<Integer> list = new ArrayList();
            Stack<TreeNode> s = new Stack<TreeNode>();
            TreeNode pre = null;
            while(root != null || !s.isEmpty()){
                //每次先找到最左边的节点
                while(root != null){
                    s.push(root);
                    root = root.left;
                }
                //弹出栈顶
                TreeNode node = s.pop();
                //如果该元素的右边没有或是已经访问过
                if(node.right == null || node.right == pre){
                    //访问中间的节点
                    list.add(node.val);
                    //且记录为访问过了
                    pre = node;
                }else{
                    //该节点入栈
                    s.push(node);
                    //先访问右边
                    root = node.right;
                }
            }
            //返回的结果
            int[] res = new int[list.size()];
            for(int i = 0; i < list.size(); i++)
                res[i] = list.get(i);
            return res;
        }




    public int[] inorderTraversal (TreeNode root) {
            //添加遍历结果的数组
            List<Integer> list = new ArrayList();
            Stack<TreeNode> s = new Stack<TreeNode>();
            //空树返回空数组
            if(root == null)
                return new int[0];
            //当树节点不为空或栈中有节点时
            while(root != null || !s.isEmpty()){
                //每次找到最左节点
                while(root != null){
                    s.push(root);
                    root = root.left;
                }
                //访问该节点
                TreeNode node = s.pop();
                list.add(node.val);
                //进入右节点
                root = node.right;
            }
            //返回的结果
            int[] res = new int[list.size()];
            for(int i = 0; i < list.size(); i++)
                res[i] = list.get(i);
            return res;
        }




        public int[] preorderTraversal2 (TreeNode root) {
            //添加遍历结果的数组
            List<Integer> list = new ArrayList();
            Stack<TreeNode> s = new Stack<TreeNode>();
            //空树返回空数组
            if(root == null)
                return new int[0];
            //根节点先进栈
            s.push(root);
            while(!s.isEmpty()){
                //每次栈顶就是访问的元素
                TreeNode node = s.pop();
                list.add(node.val);
                //如果右边还有右子节点进栈
                if(node.right != null)
                    s.push(node.right);
                //如果左边还有左子节点进栈
                if(node.left != null)
                    s.push(node.left);
            }
            //返回的结果
            int[] res = new int[list.size()];
            for(int i = 0; i < list.size(); i++)
                res[i] = list.get(i);
            return res;
        }


    public int[] preorderTraversal (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(list, root);
        int[] target = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }
    public void preOrder(List<Integer> list, TreeNode root) {
        if (root==null) return;
        if (root.left!=null) {
            preOrder(list,root.left);
        }
        if (root.right != null) {
            preOrder(list, root.right);
        }
        list.add(root.val);
    }


    //平衡二叉树
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalance(root.right) && isBalance(root.left) && Math.abs(height(root.left) - height(root.right)) < 2) {
            return true;
        }
        return false;
    }

    //最大深度
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //对称树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        findPath(root, p, path1);
        findPath(root, q, path2);
        return getLastCom(path1, path2);
    }

    private TreeNode getLastCom(Stack<TreeNode> path1, Stack<TreeNode> path2) {
        while (path1.size() != path2.size()) {
            if (path1.size() > path2.size()) {
                path1.pop();
            } else {
                path2.pop();
            }
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

    private boolean findPath(TreeNode root, TreeNode p, Stack<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.push(root);
        if (root == p) {
            return true;
        }
        if (findPath(root.left, p, path)) {
            return true;
        }
        if (findPath(root.right, p, path)) {
            return true;
        }
        path.pop();
        return false;
    }

    public List<List<Integer>> sequenceTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> ss = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ss.add(list);
        }
        return ss;
    }

    public boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean isLeaf = false;
        while (!deque.isEmpty()) {
            TreeNode cur_node = deque.pop();
            TreeNode left = cur_node.left;
            TreeNode right = cur_node.right;
            if (left == null && right != null) {
                return false;
            }
            if (isLeaf && (left == null || right == null)) {
                return false;
            }
            if (left != null) {
                deque.add(left);
            }
            if (right != null) {
                deque.add(right);
            }
            if ((left != null && right == null) || (left == null && right == null)) {
                isLeaf = true;
            }
        }
        return true;
    }

    public boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }


    // 第一个  头节点（null）   和 当前最后一个节点cur
    //第二个链表  定义一个头节点（null）
    public static ListNode oddEvenList(ListNode head) {
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode cur1 = dummyNode1;
        ListNode cur2 = dummyNode2;
        int temp = 1;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (temp % 2 != 0) {//判断奇数节点
                cur1.next = head;
                cur1 =head ;
            } else {
                cur2.next = head;
                cur2 = head;
            }
            temp++;
            head = next;
        }
        cur1.next = dummyNode2.next;
        return dummyNode1.next;
    }


    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = lists.get(i);
            listNodes.add(dummyNode);
        }
        ListNode target = new ListNode(-1);
        ListNode target_cur = target;
        //判断是否还有
        while (isHave(listNodes)) {
            //每次更新链表集合
            int temp = 0;
            ListNode cur = listNodes.get(0).next;
            for (int i = 1; i < listNodes.size(); i++) {
                if (cur.val > listNodes.get(i).next.val) {
                    cur = listNodes.get(i).next;
                    temp = i;
                }
            }
            target_cur.next = cur;
            target_cur = cur;
            listNodes.get(temp).next = listNodes.get(temp).next.next;
            listNodes = removeNull(listNodes);
        }
        return target.next;
    }
    public static boolean isHave(ArrayList<ListNode> listNodes) {
        for (int i = 0; i < listNodes.size(); i++) {
            if (listNodes.get(i).next != null) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<ListNode> removeNull(ArrayList<ListNode> listNodes) {
        ArrayList<ListNode> list = new ArrayList<>();
        for (int i = 0; i < listNodes.size(); i++) {
            if (listNodes.get(i).next != null) {
                list.add(listNodes.get(i));
            }
        }
        return list;
    }
    public static String bigNumberSum(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        while (len1 < len2) {
            a = "0" + a;
            len1++;
        }
        while (len1 > len2) {
            b = "0" + b;
            len2++;
        }
        String ss="";
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int temp = a.charAt(i) - 48 + b.charAt(i) - 48 + carry;
            ss = (temp % 10)+ss;
            carry = temp / 10;
        }
        if (carry == 1) {
            ss = 1+ss;
        }
        return ss;
    }


    public class Solution {
        public boolean hasCycle(ListNode head) {
            //先判断链表为空的情况
            if(head == null)
                return false;
            //快慢双指针
            ListNode fast = head;
            ListNode slow = head;
            //如果没环快指针会先到链表尾
            while(fast != null && fast.next != null){
                //快指针移动两步
                fast = fast.next.next;
                //慢指针移动一步
                slow = slow.next;
                //相遇则有环
                if(fast == slow)
                    return true;
            }
            //到末尾则没有环
            return false;
        }
    }


        //判断有没有环，返回相遇的地方
        public static ListNode hasCycle(ListNode head) {
            //先判断链表为空的情况
            if(head == null)
                return null;
            //快慢双指针
            ListNode fast = head;
            ListNode slow = head;
            //如果没环快指针会先到链表尾
            while(fast != null && fast.next != null){
                //快指针移动两步
                fast = fast.next.next;
                //慢指针移动一步
                slow = slow.next;
                //相遇则有环，返回相遇的位置
                if(fast == slow)
                    return slow;
            }
            //到末尾说明没有环，返回null
            return null;
        }

        public  ListNode EntryNodeOfLoop(ListNode pHead) {
            ListNode slow = hasCycle(pHead);
            //没有环
            if(slow == null)
                return null;
            //快指针回到表头
            ListNode fast = pHead;
            //再次相遇即是环入口
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }


        public static ListNode getCycleNode(ListNode head) {
            ListNode slow = hasCycle(head);
            if (slow == null) return null;
            ListNode fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }



    public static ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode fast = pHead;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        ListNode pre = dummyNode;
        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyNode.next;
    }













}
