package com.cm.special_enterprise.de.Time;

import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        
        ArrayList<Integer> integers = new ArrayList<>();
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            integers.add(1);
        }
        long endTime3 = System.currentTimeMillis();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
        long endTime = System.currentTimeMillis();
        long startTime2 = System.currentTimeMillis();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("复制所用时间：{}"+(endTime3-startTime3)+"毫秒");
        System.out.println("fori导出所用时间：{}"+(endTime-startTime)+"毫秒");
        System.out.println("foreach导出所用时间：{}"+(endTime2-startTime2)+"毫秒");
    }
}
