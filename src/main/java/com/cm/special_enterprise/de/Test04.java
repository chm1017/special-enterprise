package com.cm.special_enterprise.de;

import com.alibaba.nacos.common.utils.StringUtils;
import com.cm.special_enterprise.pojo.Tree;
import org.ehcache.shadow.org.terracotta.context.TreeNode;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class Test04 implements Runnable{
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate((new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println(++i);
            }
        }), 1000,1000);

    }

    public static String solve(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        while (len1 < len2) {
            s = "0"+s;
            len1++;
        }
        while (len1 > len2) {
            t = "0"+t;
            len2++;
        }
        String ss = "";
        int carry = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            int tmp = Integer.valueOf(s.charAt(i))-48 + Integer.valueOf(t.charAt(i))-48 + carry;
            ss=ss+String .valueOf(tmp % 10);
            carry = tmp / 10;
        }
        if (carry==1) {
            ss=ss+"1";
        }
        StringBuilder stringBuilder = new StringBuilder(ss);
        return stringBuilder.reverse().toString();

    }

    public static List<String> getposition(int x, int y, int m, int n) {
        ArrayList<String> strings = new ArrayList<String>();
        if (x == m&&y+1==n) {
            strings.add("x-1,y-1");
            strings.add("x+1,y-1");
        }
        return null;
    }

    public static int minDepth(Tree root) {
        if (root == null) {
            return 0;
        }
        return Math.min(minDepth(root.getLeft()) + 1, minDepth(root.getRight()) + 1);
    }

    public static int maxDepth(Tree root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.getLeft()) + 1, maxDepth(root.getRight()) + 1);
    }

    public static String sum(String s, String t) {
        int number1[] = new int[5000];
        int number2[] = new int[5000];
        int result[] = new int[5000];
        int i, j;
        for (i = 0, j = s.length() - 1; j >= 0; j--, i++) {
            number1[i] = s.charAt(j)-48;
        }
        for (i = 0, j = t.length() - 1; j >= 0; j--, i++) {
            number2[i] = t.charAt(j)-48;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int k = 0; k < 5000; k++) {
            int sum = number1[k] + number2[k];
            if (sum >= 10) {
                integers.add(k + 1);
                result[k] = sum % 10;
            } else {
                result[k] = sum;
            }
        }
        for (Integer integer : integers) {
            result[integer] = result[integer] + 1;
            if (result[integer] >= 10) {
                result[integer] = result[integer] % 10;
                result[integer+1]+=1;
                int term = integer + 1;
                while (true) {
                    if (result[term] >= 10) {
                        result[term] = result[term] % 10;
                        result[term + 1] += 1;
                        term++;
                    } else {
                        break;
                    }
                }
            }
        }
        String ss = "";
        int flag = 0;
        for (int k =result.length-1; k >=0; k--) {
            if (flag == 0) {
                while (result[k] != 0) {
                    ss += result[k];
                    flag = 1;
                    break;
                }
            } else {
                ss+=result[k];
            }
        }
        if (ss == null || "".equals(ss)) {
            return "0";
        }
        return ss;
    }

    public static Integer getInt(String a) {
        int i, j;
        int sum=0;
        for (i = 0, j = a.length() - 1; j >= 0; j--, i++) {
            sum += (a.charAt(j)-48)* Math.pow(10, i);
        }
        System.out.println(sum);
        return 0;
    }


    @Override
    public void run() {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> reverseMap = new HashMap<>();
        hashMap.forEach((k, v) -> reverseMap.put(v, k));


    }
}
