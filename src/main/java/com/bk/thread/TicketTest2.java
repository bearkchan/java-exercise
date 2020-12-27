package com.bk.thread;

/**
 * Create by bear
 * Date 2020/12/26 11:39 上午
 */
public class TicketTest2 {


    public static void main(String[] args) {
        Window2 window1 = new Window2();
        Window2 window2 = new Window2();
        Window2 window3 = new Window2();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window2 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (show()) {
                break;
            }
        }
    }

    /**
     * 继承Thread使用synchronized同步方法需要注意设置为static。
     * @return
     */
    private static synchronized boolean show() {
        if (ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        } else {
            return true;
        }
        return false;
    }
}