package com.bk.thread;


/**
 * Create by bear
 * Date 2020/12/26 2:02 下午
 */
public class BankTest {
    public static void main(String[] args) {
        BankThread bankThread = new BankThread();
        for (int i = 0; i < 100; i++) {
            new Thread(bankThread, "Thread" + (i + 1)).start();
        }

    }
}


/**
 * 单例模式的懒汉式demo
 */
class Bank {
    private Bank() {
        System.out.println("new bank is created");
    }

    private static Bank instance;

    /**
     * 方式1：直接在方法上添加synchronized
     */
    //public static synchronized   Bank getInstance() {
    //    if (instance == null) {
    //        instance = new Bank();
    //    }
    //    return instance;
    //}

    /**
     * 方式2：使用synchronized代码块
     */
    //public static Bank getInstance(){
    //    synchronized (Bank.class){
    //        if (instance==null){
    //            instance = new Bank();
    //        }
    //        return instance;
    //    }
    //}


    /**
     * 方式3：使用双重检查，提供线程效率
     */
    public static Bank getInstance() {
        // 第一重检查
        if (instance == null) {
            synchronized (Bank.class) {
                // 第二重检查
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

class BankThread implements Runnable {
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName() + "线程开始运行");
        Bank.getInstance();
    }
}