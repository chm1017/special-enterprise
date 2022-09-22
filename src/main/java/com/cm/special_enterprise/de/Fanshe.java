package com.cm.special_enterprise.de;


import com.cm.special_enterprise.pojo.SimpleDictionaryEntity;
import com.cm.special_enterprise.pojo.TestEntity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Fanshe {
    public static <T> T setParam(Class<T> clazz, Object[] args)
            throws Exception {
        if (clazz == null || args == null) {
            throw new IllegalArgumentException();
        }
        T t = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length > args.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fields[i].set(t, args[i]);
        }
        return t;
    }



    public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<>();
        strings.add("111");
        strings.add("222");
        strings.add("333");
        strings.add("4444");

   

        TestEntity testEntity = new TestEntity();
        Class a = testEntity.getClass();
        System.out.println(a);
        Class b = TestEntity.class;
        System.out.println(a == b);
        Class c = Class.forName("com.cm.special_enterprise.pojo.TestEntity");
        System.out.println(b==c);

    }
}
