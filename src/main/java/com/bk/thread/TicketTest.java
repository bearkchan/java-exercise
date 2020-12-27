package com.bk.thread;

/**
 * Create by bear
 * Date 2020/12/26 11:39 上午
 */
public class TicketTest {


    public static void main(String[] args) {
        Window window = new Window();
        new Thread(window, "窗口1").start();
        new Thread(window, "窗口2").start();
        new Thread(window, "窗口3").start();
    }
}

class Window implements Runnable {
    private int ticket = 100;
    //private Object obj = new Object();

    @Override
    public void run() {
        /**
         * synchronized(同步监视器){
         *     // ...需要被同步的代码块
         * }
         * 说明：
         *  1. synchronized代码块里面操作需要共享的数据内容，如ticket
         *  2. 同步监视器其实就是一把锁。任何一个类的对象，都可以作为锁
         *⚠️3. 多个线程必须共用一把锁
         */
        //synchronized (obj) {
        //synchronized (this) {
        synchronized (Window.class) {  // Class clazz = Window.class , Window.class也是一个对象，且只被加载一次
            while (true) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}