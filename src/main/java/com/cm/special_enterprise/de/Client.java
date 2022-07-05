package com.cm.special_enterprise.de;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        Test_Extend2 test_extend2 = new Test_Extend2();
        test_extend2.setAddress("hello");
        test_extend2.setAge("11");
        test_extend2.setName("xiao");
        Test_Extend test_extend = test_extend2;

        Test_Extend2 test_extend1 = (Test_Extend2) new Test_Extend();

        System.out.println(test_extend.toString());


    }
}
