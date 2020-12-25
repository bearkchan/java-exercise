package com.bk.thread;

public class ThreadTest {
    public static void main(String[] args) {
        // 获取100以内的奇数
        new Thread("奇数线程") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "--->" + i);
                    }
                }
            }
        }.start();
        // 获取100以内的偶数
        new Thread("偶数线程") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "--->" + i);
                    }
                }
            }
        }.start();
    }
}
