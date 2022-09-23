package com.cm.special_enterprise.de.thread.cunMoney;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;//余额
    private Lock accountLock = new ReentrantLock();

    public void deposit(double money) {
        accountLock.lock();

        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
        }finally {
            accountLock.unlock();
        }

    }

    public double getBalance() {
        return balance;
    }



}
