package com.cm.special_enterprise.de.thread;

import org.apache.poi.ss.formula.functions.T;

public class Test01 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这是多线程调用" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] target = new int[5];
        int length = target.length;
        System.out.println(2 >> 3);
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        Test01 test01 = new Test01();
        Thread thread = new Thread(new DemoRunnable());

        test01.start();
        Thread.sleep(1000);
        thread.start();
    }
}
