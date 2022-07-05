package com.cm.special_enterprise.de;

import com.alibaba.excel.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
    public static void main(String[] args) {
        String a = "8";
        String b = "1";
        sum(a, b);
    }
     static void sum(String a, String b) {
        //设定a是长的
        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        //反转字符串
        StringBuilder aB = new StringBuilder(a);
        String ar = String.valueOf(aB.reverse());
        StringBuilder bB = new StringBuilder(b);
        String br = String.valueOf(bB.reverse());
        //字符串转数组
        String[] as = ar.split("");
        String[] bs = br.split("");
        ArrayList<String> alist = new ArrayList<>();
        for (String aa :as) {
            alist.add(aa);
        }
        ArrayList<String> blist = new ArrayList<>();
        for (String bb :bs) {
            blist.add(bb);
        }
        List<String> list = new ArrayList<String>();
         for (String s : list ) {

             System.out.println(s);
         }
         int i = 0;
         Boolean flag = false;
         while (i < alist.size()) {
             String j;
             if (i < blist.size()) {
                 if (flag = false) {
                     if (Integer.parseInt(alist.get(i)) + Integer.parseInt(blist.get(i)) >= 10) {
                         j = String.valueOf(Integer.parseInt(alist.get(i)) + Integer.parseInt(blist.get(i))).substring(1, 2);
                         list.add(j);
                         flag = true;
                     } else {
                         j = String.valueOf(Integer.parseInt(alist.get(i)) + Integer.parseInt(blist.get(i)));
                         list.add(j);
                         flag = false;
                     }
                 } else {
                     if (Integer.parseInt(alist.get(i)) + Integer.parseInt(blist.get(i)) + 1 >= 10) {
                         j = String.valueOf(Integer.parseInt(alist.get(i)) + Integer.parseInt(blist.get(i)) + 1).substring(1, 2);
                         list.add(j);
                         flag = true;
                     } else {
                         j = String.valueOf(Integer.parseInt(alist.get(i)) + Integer.parseInt(blist.get(i) + 1));
                         list.add(j);
                         flag = false;
                     }
                 }

             } else if (flag) {
                 if (Integer.parseInt(alist.get(i)) + 1 >= 10) {
                     j = String.valueOf(Integer.parseInt(alist.get(i)) + 1).substring(1, 2);
                     list.add(j);
                     flag = true;
                 } else {
                     j = String.valueOf(Integer.parseInt(alist.get(i)));
                     list.add(j);
                     flag = false;
                 }

             }
             else {
                 j = String.valueOf(Integer.parseInt(alist.get(i)));
                 list.add(j);
                 flag = false;
             }
         }



    }

}
