package com.cm.special_enterprise.de.leecode;

import cn.afterturn.easypoi.cache.manager.IFileLoader;
import cn.hutool.core.text.csv.CsvUtil;

import javax.persistence.Index;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int[] sum = new int[]{-10, 0, 10, 20, -10, -40};
        findKthLargest(sum, 2);
        System.out.println(threeSum(sum));
        System.out.println(maxLength(sum));
        int[] s = new int[]{2, 3, 4, 5};
        sortColors(s);
        String patternString = "";
        Pattern pattern = null;
        Matcher matcher = null;
        String normalizedString = "";
        String string = "A man, a plan, a canal: Panama";
        patternString = "[^A-Za-z0-9]";
        System.out.println(string.replaceAll(patternString, ""));
        pattern = Pattern.compile(patternString);
        matcher = pattern.matcher(string);
        normalizedString = matcher.replaceAll("");
        System.out.println(normalizedString);
        System.out.println(isPalindrome(string));
        System.out.println(reverseVowels("ikeone"));

        System.out.println(divide(-2147483648, -1));


    }

    public int[] gaoaiSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    // 偷第一家  只能到n-1 家    偷  第二家 只能到n









//    1→2→3→3→4→4→5,
    public ListNode deleteDuplicates (ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        ListNode cur_next;

        while (cur != null && cur.next != null) {
            cur_next = cur.next;
            if (cur.val != cur_next.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                cur_next = cur_next.next;
            }
        }
        return dummyNode.next;

    }


    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            int x = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (strs[j].charAt(i) != x) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDic = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDic.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int  flag = 0;
        if (dividend < 0) {
            dividend = -dividend;
            flag++;
        }
        if (divisor < 0) {
            divisor = -divisor;
            flag++;
        }
        boolean is = true;
        if (flag % 2!=0) {
            is = false;
        }
        int target = 0, index = -1;
        while (target <= dividend) {
            target += divisor;
            index++;
        }
        return is ? index : -index;
    }




    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int minlen = nums.length + 1;
        while (left < nums.length) {
            if (sum < target && right+1 < minlen) {
                sum += nums[right++];
            } else {
                sum -= nums[left++];
            }
            if (sum > target) {
                minlen = Math.min(minlen, right - left + 1);
            }
        }

        return minlen ==nums.length + 1?0:minlen;

    }
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0;
        int j = len - 1;
        int target = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > target) {
                target = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return target;
    }
    public static boolean   vowel(char vow)
    {
        if (vow == 'a' || vow == 'e' || vow == 'i' || vow == 'o' || vow == 'u' || vow == 'A' || vow == 'E' || vow == 'I' || vow == 'O' || vow == 'U')
            return true;
        else
            return false;
    }
    public static String reverseVowels(String s) {
        int len = s.length();
        int i = 0;
        int j = len - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (!vowel(s.charAt(i)) && i < j) {
                i++;
            }
            while (!vowel(s.charAt(j)) & i < j) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        StringBuilder target = new StringBuilder();
        for (int k = 0; k < chars.length; k++) {
            target.append(chars[k]);
        }
        return target.toString();
    }


    public static boolean isPalindrome(String s) {
        String  reg = "[^A-Za-z0-9]";
        String target = s.replaceAll(reg, "").toLowerCase().trim();
        for (int i = 0; i < target.length() / 2; i++) {
            if (target.charAt(i) != target.charAt(target.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j] )== target) {
                return new int[]{i + 1, j + 1};
            } else if ((numbers[i] + numbers[j]) < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target-numbers[i])) {
                map.put(numbers[i], i + 1);
            } else {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
        }
        return new int[]{};
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        int p = m - 1;
        int q = n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[cur--] = nums1[p--];
            } else {
                nums1[cur--] = nums2[q--];
            }
        }
        while (p >= 0) {
            nums1[cur--] = nums1[p--];
        }
        while (q >= 0) {
            nums1[cur--] = nums2[q--];
        }
    }
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int temp = nums[l];
                nums[l++] = nums[i];
                nums[i] = temp;
            }
            if (nums[i] == 2) {
                int temp = nums[r];
                nums[r--] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static int maxLength2(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    int len = j - i;
                    if (len > target) {
                        target = len;
                    }
                    break;
                }
                if (j == arr.length - 1) {
                    if (arr.length - i > target) {
                        target = arr.length - i;
                    }
                }
            }
        }
        return target;
    }

    public static int maxLength (int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                k++;
                map.put(arr[i], i);
            } else {
                int l = i - map.get(arr[i]);
                boolean flag = true;
                if ( l >= k) {
                    for (int j = i-1; j >i-l ; j--) {
                        if (j != map.get(arr[j]))  flag = false;
                    }
                    if (flag) k = i - map.get(arr[i]);
                }
                map.put(arr[i], i);
            }
        }
        return k;
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

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num.length < 3) {
            return new ArrayList<ArrayList<Integer>>();
        }

        HashMap<Integer, Integer> indexState = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (!indexState.containsKey(num[i])) {
                indexState.put(num[i], 0);
            }
        }
        ArrayList<ArrayList<Integer>> sum = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length; i++) {
            int target = -num[i];
            ArrayList<Integer> map = new ArrayList<Integer>();
            for (int j = i+1; j < num.length; j++) {
                if (map.contains(target - num[j])) {
                    if (indexState.get(-target) != 1 || indexState.get(target - num[j]) != 1 || indexState.get(num[j])!=1) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(-target);
                        indexState.put(-target, 1);
                        list.add(target - num[j]);
                        indexState.put(target - num[j], 1);
                        list.add(num[j]);
                        indexState.put(num[j], 1);
                        sum.add(list);
                    }
                } else {
                    map.add(num[j]);
                }
            }
        }
        return sum;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null ) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode m = head;
        ListNode k = head;
        while (k!= null && k.next != null) {
            m = m.next;
            k = k.next.next;
            if (m == k) {
                return true;
            }
        }
        return false;
    }

    public ListNode reverseBetween2 (ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode fast = cur.next;
        for (int i = 0; i < n - m; i++) {
            ListNode fast_next = fast.next;
            cur.next = fast.next;
            fast.next = cur;
            pre.next = fast;
            cur = fast;
            fast = fast_next;
        }
        return dummyNode.next;
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                int temp = nums[k];
                nums[k++] = nums[i];
                nums[i] = temp;
            }
        }
        return k;
    }


    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int k = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }

    public int removeDuplicates2(int[] nums) {
        int len = nums.length;
        int k = 0;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[k]) {
                temp++;
                if (temp < 2) {
                    nums[++k] = nums[i];
                }
            } else {
                temp = 0;
                nums[++k] = nums[i];
            }

        }
        return k+1;

    }

    public int removeDuplicates22(int[] nums) {
        int len = nums.length;
        int k = 0;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[k]) {
                temp++;
                if (temp < 2) {
                    nums[++k] = nums[i];
                }
            } else {
                temp = 0;
                nums[++k] = nums[i];
            }

        }
        return k+1;

    }









//    一个快指针  一个满指针







}
