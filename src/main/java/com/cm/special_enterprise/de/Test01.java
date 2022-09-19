package com.cm.special_enterprise.de;


import com.cm.special_enterprise.de.leecode.ListNode;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.joda.time.LocalDate;

import java.text.Format;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import javax.activation.*;

public class Test01 {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        String key = "iKeone";
        System.out.println(key.hashCode());
        int h;
        System.out.println(new LocalDate());
        System.out.println((h=key.hashCode())^(h>>>16));
        System.out.println(isPalindrome(10));

        String a = "10";
        System.out.println(isPalindrome(10));

    }

    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.contains("-")) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }




    public static boolean isTrue(String a, String b) {
        if (!a.equals(b)) {
            return false;
        }
        if (a.length() > 1 && b.length() > 1) {
            isTrue(a.substring(0, a.length() / 2), a.substring(a.length() / 2, a.length()));
            isTrue(b.substring(0, a.length() / 2), b.substring(a.length() / 2, a.length()));
        }
        return true;
    }

    private int getValue(char ch) {
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

    public int getNum(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum > num) {
                sum += preNum;
            } else {
                sum -= preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {

            }
        }
        return "";
    }
     public class ListNode {
     int val;
     com.cm.special_enterprise.de.leecode.ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, com.cm.special_enterprise.de.leecode.ListNode next) { this.val = val; this.next = next; }
 }




}
