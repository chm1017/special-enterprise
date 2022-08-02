package com.cm.special_enterprise.de.thread;

public class DemoRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这是线程执行得方法啊。。。。。。。。。。");
        }

    }
}
