package com.cm.special_enterprise.de.leecode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;

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
        // dp[i][j] ?????? s[i..j] ??????????????????
        boolean[][] dp = new boolean[len][len];
        // ??????????????????????????? 1 ????????????????????????
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // ????????????
        // ?????????????????????
        for (int L = 2; L <= len; L++) {
            // ????????????????????????????????????????????????????????????
            for (int i = 0; i < len; i++) {
                // ??? L ??? i ??????????????????????????? j - i + 1 = L ???
                int j = L + i - 1;
                // ???????????????????????????????????????????????????
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
                // ?????? dp[i][L] == true ???????????????????????? s[i..L] ???????????????????????????????????????????????????
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
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (isHuiwen(s.substring(i, j)) && s.substring(i, j).length() > max) {
                    max = s.substring(i, j).length();
                    target = s.substring(i, j);
                }
            }
        }
        return target;
    }



        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int best = 10000000;

            // ?????? a
            for (int i = 0; i < n; ++i) {
                // ??????????????????????????????????????????
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // ????????????????????? b ??? c
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    // ???????????? target ??????????????????
                    if (sum == target) {
                        return target;
                    }
                    // ???????????????????????????????????????
                    if (Math.abs(sum - target) < Math.abs(best - target)) {
                        best = sum;
                    }
                    if (sum > target) {
                        // ??????????????? target????????? c ???????????????
                        int k0 = k - 1;
                        // ????????????????????????????????????
                        while (j < k0 && nums[k0] == nums[k]) {
                            --k0;
                        }
                        k = k0;
                    } else {
                        // ??????????????? target????????? b ???????????????
                        int j0 = j + 1;
                        // ????????????????????????????????????
                        while (j0 < k && nums[j0] == nums[j]) {
                            ++j0;
                        }
                        j = j0;
                    }
                }
            }
            return best;
        }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};

        System.out.println(permute(a));
    }


        public static List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<String>();
            if (digits.length() == 0) {
                return combinations;
            }
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};

            backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
            return combinations;
        }

        public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, phoneMap, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }


        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int[] visited = new int[nums.length];
            backtrack(res, nums, new ArrayList<Integer>(), visited);
            return res;
        }

        private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) continue;
                visited[i] = 1;
                tmp.add(nums[i]);
                backtrack(res, nums, tmp, visited);
                visited[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
}
