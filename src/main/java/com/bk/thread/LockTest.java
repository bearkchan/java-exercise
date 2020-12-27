package com.bk.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by bear
 * Date 2020/12/27 6:03 下午
 */
public class LockTest {
    public static void main(String[] args) {
        Window3 window3 = new Window3();
        new Thread(window3, "线程1").start();
        new Thread(window3, "线程2").start();
        new Thread(window3, "线程3").start();
    }
}


class Window3 implements Runnable {
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 锁住
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":取票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
