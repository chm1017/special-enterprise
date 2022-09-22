package com.cm.special_enterprise.de.thread;

import org.apache.poi.ss.formula.functions.T;

public class Test01 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这是多线程调用" + i);
        }
    }
}
