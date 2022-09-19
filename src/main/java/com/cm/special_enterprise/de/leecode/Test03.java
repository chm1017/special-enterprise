package com.cm.special_enterprise.de.leecode;

import com.graphbuilder.math.func.LnFunction;
import org.checkerframework.checker.units.qual.min;
import org.springframework.boot.rsocket.server.RSocketServer;
import org.tartarus.snowball.ext.EstonianStemmer;
import sun.rmi.transport.Transport;

import java.util.*;

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

        int a = 1989;
        System.out.println(isHuiwenInteger(a));

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

    public static boolean isHuiwenInteger(int a) {
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        while (a != 0) {
            int s = a % 10;
            integers.add(s);
            a = a / 10;
        }
        while (integers.size() != 1&&!integers.isEmpty() ) {
            int f = integers.pollFirst();
            int l = integers.pollLast();
            if (f != l) {
                return false;
            }
        }
        return true;
    }

    public int maxArea(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int area = a[j] > a[i] ? a[i] : a[j] * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }


        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuffer roman = new StringBuffer();
            for (int i = 0; i < values.length; ++i) {
                int value = values[i];
                String symbol = symbols[i];
                while (num >= value) {
                    num -= value;
                    roman.append(symbol);
                }
                if (num == 0) {
                    break;
                }
            }
            return roman.toString();
        }

    public String reverse(int a) {
        String s = String.valueOf(a);
        int length = s.length();
        return null;
    }


        public int romanToInt(String s) {
            //计算值
            int sum = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int j = getValue(chars[i]);

                int k;
                if (i < chars.length - 1) {
                    k= getValue(chars[i + 1]);
                } else {
                    k = getValue(chars[chars.length - 1]);
                }

                if (j < k) {
                    sum = sum + k - j;
                    i++;
                } else {
                    sum = sum + j;
                }
            }
            return sum;
        }
        private static int getValue(char ch) {
            switch(ch) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }


    public String common(String[] ss) {
        StringBuffer stringBuffer = new StringBuffer("");
        int maxString = ss[0].length();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].length() > maxString) {
                maxString = ss[i].length();
            }
        }
        for (int k = 0; k < maxString; k++) {
            char c = ss[0].charAt(k);
            for (int i = 1; i < ss.length; i++) {
                if (c != ss[i].charAt(k)) {
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }



        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 枚举 a
            for (int first = 0; first < n; ++first) {
                // 需要和上一次枚举的数不相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = n - 1;
                int target = -nums[first];
                // 枚举 b
                for (int second = first + 1; second < n; ++second) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
}
