package com.cm.special_enterprise.de.thread;

public class SaiPao implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("乌龟") && i % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }

    }

    public boolean gameOver(int temp) {
        if (winner != null) {
            return true;
        }
        if (temp >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("胜利者是" + winner);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        SaiPao saiPao = new SaiPao();
        new Thread(saiPao, "兔子").start();
        new Thread(saiPao, "乌龟").start();
    }
}
