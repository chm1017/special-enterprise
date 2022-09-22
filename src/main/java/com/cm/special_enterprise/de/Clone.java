package com.cm.special_enterprise.de;

import com.cm.special_enterprise.pojo.Address;
import com.cm.special_enterprise.pojo.Student;

import java.util.HashMap;

public class Clone {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(13, 11);
        map.put(24, 11);
        System.out.println(map.hashCode());
        Student student = new Student();
        student.setName("阿珂");
        student.setAge(22);
        Address address = new Address();
        address.setId(1l);
        address.setDescribe("黄庄");
        student.setAddress(address);
        try {
            Student clone = (Student) student.clone();
            System.out.println(clone.getAddress() == student.getAddress());
            student.setAge(23);
            System.out.println(student+"          "+clone);
            System.out.println("修改引用类型");
           student.getAddress().setDescribe("郭岸下");
            System.out.println(student+"          "+clone);

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
