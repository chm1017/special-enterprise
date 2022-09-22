package com.cm.special_enterprise.de;

import cn.hutool.core.collection.CollectionUtil;
import com.cm.special_enterprise.pojo.TestEntity;

import java.util.*;
import java.util.function.Consumer;

public class Test05 {
    public static void main(String[] args) {
        System.out.println(3*0.1);
        double bb = 3 * 0.1;
        double b = 0.3;
        System.out.println(bb==b);
        String a ="198003";
        System.out.println(a.substring(0, 4));
        System.out.println(a.substring(4, 6));
        String s = "1,2";
        String[] split = s.split(",");
        System.out.println(split);
        ArrayList<String> strings = CollectionUtil.newArrayList(split);
        for (String string : strings) {
            System.out.println(string);

        }


        TestEntity one = new TestEntity();
        one.setName("小珂");
        one.setAge(22);

        TestEntity three = new TestEntity();
        three.setName("小王");
        three.setAge(26);
        TestEntity four = new TestEntity();
        four.setName("小四");
        four.setAge(18);
        ArrayList<TestEntity> list = new ArrayList<>();
        list.add(one);
        list.add(three);
        list.add(four);
        System.out.println(list);

        Comparator<TestEntity> comparator = new Comparator<TestEntity>() {
            @Override
            public int compare(TestEntity o1, TestEntity o2) {
                Integer age1 = o1.getAge();
                Integer age2 = o2.getAge();
                return age1.compareTo(age2);
            }
        };
        Collections.sort(list, comparator);

        System.out.println(list);
    }

}
