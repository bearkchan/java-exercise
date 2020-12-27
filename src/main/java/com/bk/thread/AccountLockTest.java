package com.bk.thread;

/**
 * Create by bear
 * Date 2020/12/27 6:13 下午
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打 印账户余额。
 * <p>
 * 问题：该程序是否有安全问题，如果有，如何解决？
 * <p>
 * 【提示】 1，明确哪些代码是多线程运行代码，须写入run()方法 2，明确什么是共享数据。 3，明确多线程运行代码中哪些语句是操作共享数据的。
 */
class Account extends Thread {
    private double money;

    public void setMoney(double money) {
        this.money += money;
    }

    public double getMoney() {
        return money;
    }
}

class Customer extends Thread {
    private Account account;
    private static ReentrantLock lock = new ReentrantLock(true);

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setMoney(1000);
                System.out.println(getName() + ":存了1000元,账户余额为:" + account.getMoney());
            }
        } finally {
            lock.unlock();
        }

    }
}

public class AccountLockTest {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("小明");
        customer2.setName("小黑");

        customer1.start();
        customer2.start();
    }
}
