package com.cm.special_enterprise.de.leecode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class C8_15 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            for(int i = 0; i < s.length(); i ++){
                if(map.containsKey(s.charAt(i))){
                    left = Math.max(left,map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i),i);
                max = Math.max(max,i-left+1);
            }
            return max;

        }
    }

    public static int getLengestString(String s) {
        int max = 0;
        ArrayDeque<Char> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            while (deque.contains(s.charAt(i))) {
                deque.pollFirst();
            }
            max = max >= deque.size() ? max : deque.size();
        }
        return max;
    }

    public ArrayList<Integer> mergeSort(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                list.add(a[i++]);

            } else {
                list.add(b[j++]);
            }
        }
        while (i < a.length) {
            list.add(a[i++]);
        }
        while (j < b.length) {
            list.add(b[j++]);
        }
        return list;
    }

    public double getMid(int[] a, int[] b) {
        ArrayList<Integer> arrayList = mergeSort(a, b);
        if (arrayList.size() % 2 == 0) {
            return (double) (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1)) / 2;
        } else {
            return arrayList.get(arrayList.size() / 2);
        }
    }




    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public boolean isHuiwen(String s) {
        int i;
        for (i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String largestHuiwen(String s) {
        if (s.length() < 2) {
            return s;
        }
        int max = 0;
        String target = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (isHuiwen(s.substring(i, j)) && s.substring(i, j).length() > max) {
                    max = s.substring(i, j).length();
                    target = s.substring(i, j);
                }
            }
        }
        return target;
    }


}
