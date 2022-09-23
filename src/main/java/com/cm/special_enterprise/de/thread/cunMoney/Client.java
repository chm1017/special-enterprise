package com.cm.special_enterprise.de.thread.cunMoney;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {


        Account account = new Account();
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        ExecutorService threadPool = Executors.newFixedThreadPool(100);
//        for (int i = 0; i < 1000000; i++) {
//            threadPool.execute(new AddObjectToList(list,1));
//        }
//        threadPool.shutdown();
//        while (!threadPool.isTerminated()) {
//        }
        System.out.println(list.size());
    }
}
