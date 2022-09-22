package com.cm.special_enterprise.de.thread;

public class QiangPiao implements Runnable {
    private Integer totalTicket = 500;
    private Boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    private synchronized void buy() {
        if (totalTicket <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "拿到了第" + totalTicket-- + "张票");
    }

    public static void main(String[] args) {
        QiangPiao qiangPiao = new QiangPiao();
        new Thread(qiangPiao, "小明").start();
        new Thread(qiangPiao, "小珂").start();
        new Thread(qiangPiao, "黄牛").start();
    }
}
