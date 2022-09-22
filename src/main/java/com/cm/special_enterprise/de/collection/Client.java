package com.cm.special_enterprise.de.collection;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.text.SimpleDateFormat;
import java.util.*;

public class Client {

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers.pollLast());
        ArrayDeque<Integer> integers2 = new ArrayDeque<>(integers);
        System.out.println(integers2.size());
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        String str1 = "和谐";
        String str2 = "社会";
        String str3 = "和谐社会";
        String str4;
        str4=str1 + str2;
        System.out.println(str3 == str4);
        str4 = (str1 + str2).intern();
        System.out.println(str3 == str4);

        Vector<Integer> integer = new Vector<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(2);
//        integers1.add(3);
        integer.addAll(0, integers1);
        System.out.println(integers.toArray());
        TreeMap<String, String> stringStringTreeMap = new TreeMap<>();




    }

}
