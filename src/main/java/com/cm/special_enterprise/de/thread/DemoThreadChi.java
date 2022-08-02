package com.cm.special_enterprise.de.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoThreadChi {
    private static int POOL_NUM = 10;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < POOL_NUM; i++) {
            RunnableThread runnableThread = new RunnableThread();
            es.execute(runnableThread);
        }
        es.shutdown();
    }

}

class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("通过线程池创建线程" + Thread.currentThread().getName());
    }
}