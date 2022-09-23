package com.cm.special_enterprise.de.leecode;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class one {
    //    打家劫舍1
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0], second = nums[1];
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(second, nums[i] + first);
            first = temp;
        }
        return second;
    }

    //打家劫舍2
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(getRob2(nums, 0, len - 1), getRob2(nums, 1, len));
    }

    public int getRob2(int[] nums, int start, int end) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0], second = nums[1];
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(second, nums[i] + first);
            first = temp;
        }
        return second;
    }

    //    前序遍历非递归
    public int[] preTraversal(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(root.right);
            }
            if (node.left != null) {
                stack.push(root.left);
            }
        }
        int[] target = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    //前序遍历 非递归
    public int[] preTraversal1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        int[] target = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    //    中序遍历 非递归
    public int[] inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return null;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        int[] target = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    //[8,9,2,5,4,7,1]
//    买股票的最好时机       解题思路  最小价格  和最大收益
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < len; i++) {
            maxprofit = Math.max(prices[i] - minPrice, maxprofit);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxprofit;

    }

    //    买股票的最好时机2   后一次减前一次大于零的话，相加
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    //    字符串最长公共前缀
    public String maxlength(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (i >= strs[j].length() || temp != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //奇偶重排
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ji = head;
        ListNode ou = head.next;
        ListNode ouHead = ou;
        while (ou != null && ou.next != null) {
            ji.next = ou.next;
            ji = ji.next;
            ou.next = ji.next;
            ou = ou.next;
        }
        ji.next = ouHead;
        return ji;
    }


    public ListNode deleteDuplicate(ListNode head) {
        //空链表
        if (head == null)
            return null;
        //遍历指针
        ListNode cur = head;
        //指针当前和下一位不为空
        while (cur != null && cur.next != null) {
            //如果当前与下一位相等则忽略下一位
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
                //否则指针正常遍历
            else
                cur = cur.next;
        }
        return head;
    }


    //    删除链表重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode delDuplicate(ListNode head) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        //空链表
        if (head == null)
            return null;
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            //遇到相邻两个节点值相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                //将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp)
                    cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        //返回时去掉表头
        return res.next;
    }

    //        逆序对
    public int InversePairs(int[] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    k++;
                }
            }
        }
        return k;
    }

    //      旋转数组
    public int minNumberInRotateArray(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i - 1] > a[i]) {
                return a[i];
            }
        }
        return a[0];
    }



//    比较版本号
public static int compare (String version1, String version2) {
    String[] s1 = version1.split("\\.");
    String[] s2 = version2.split("\\.");
    int k = 0;
    while (k < s1.length && k < s2.length) {
        if (Integer.valueOf(s1[k]).equals(Integer.valueOf(s2[k]))) {
            k++;
        } else if (Integer.valueOf(s1[k]) < Integer.valueOf(s2[k])) {
            return -1;
        } else {
            return 1;
        }
    }
    if (k < s1.length) {
        while (k < s1.length) {
            if (Integer.valueOf(s1[k++] )!= 0) {
                return 1;
            }
        }
    } else if (k < s2.length) {
        while (k < s2.length) {
            if (Integer.valueOf(s2[k++]) != 0) {
                return -1;
            }
        }
    }
    return 0;
}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        int temp = 0;
        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + temp) % 10;
            temp = (l1.val + l2.val + temp) / 10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = (l1.val + temp) % 10;
            temp = (l1.val + temp)/10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = (l2.val + temp) % 10;
            temp = (l2.val + temp)/10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }
        if (temp != 0) {
            ListNode node = new ListNode(1);
            head.next = node;
        }
        return dummyNode.next;
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left+1);
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        Deque<Character> stack = new ArrayDeque<Character>() {
        };
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (stack.contains(s.charAt(i))) {
                stack.peekFirst();
            }
            stack.offer(s.charAt(i));
            max = Math.max(stack.size(), max);
        }
        return max;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] target = mergeArray(nums1, nums2);
        if (target.length % 2 == 0) {
            return (double) (target[target.length / 2] + target[target.length / 2 - 1])/2;
        } else {
            return target[target.length / 2];
        }
    }

    public int[] mergeArray(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] target = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                target[k++] = nums1[i++];
            } else {
                target[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            target[k++] = nums1[i++];
        }
        while (j < len2) {
            target[k++] = nums2[j++];
        }
        return target;
    }

    public String longestPalindrome(String s) {
        int max = 0;
        String target = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j =i+1; j <=s.length() ; j++) {
                if (isHuiwen(s.substring(i, j))&&(j-i)>max) {
                    max = j - i;
                    target = s.substring(i, j);
                }
            }
        }
        return target;
    }

    public boolean isHuiwen(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


        public String convert2(String s, int numRows) {
            if(numRows < 2) return s;
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for(char c : s.toCharArray()) {
                rows.get(i).append(c);
                if(i == 0 || i == numRows -1) flag = - flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder row : rows) res.append(row);
            return res.toString();
        }


    public String convert(String s, int numRows) {
        if (numRows<2) return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i==0||i==numRows-1) flag = -flag;
            i += flag;
        }
        StringBuilder target = new StringBuilder();
        for (StringBuilder row : rows) {
            target.append(row);
        }
        return target.toString();
    }

//  接雨水问题
        public long maxWater (int[] arr) {
            //排除空数组
            if(arr.length == 0)
                return 0;
            long res = 0;
            //左右双指针
            int left = 0;
            int right = arr.length - 1;
            //中间区域的边界高度
            int maxL = 0;
            int maxR = 0;
            //直到左右指针相遇
            while(left < right){
                //每次维护往中间的最大边界
                maxL = Math.max(maxL, arr[left]);
                maxR = Math.max(maxR, arr[right]);
                //较短的边界确定该格子的水量
                if(maxR > maxL)
                    res += maxL - arr[left++];
                else
                    res += maxR - arr[right--];
            }
            return res;
       }



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("ikeone"));

    }

}
