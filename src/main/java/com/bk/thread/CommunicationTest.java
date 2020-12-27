package com.bk.thread;

/**
 * Create by bear
 * Date 2020/12/27 6:44 下午
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number, "线程1").start();
        new Thread(number, "线程2").start();
    }
}

class Number implements Runnable {
    private int num = 1;


    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}