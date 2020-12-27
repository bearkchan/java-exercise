package com.bk.thread.test;

/**
 * Create by bear
 * Date 2020/12/27 8:14 下午
 */
public class ProductorAndCustomerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        productor.setName("生产者");
        Customer customer1 = new Customer(clerk);
        customer1.setName("消费者1");
        Customer customer2 = new Customer(clerk);
        customer2.setName("消费者2");

        productor.start();
        customer1.start();
        customer2.start();


    }
}

class Clerk {
    private int product = 0;

    public synchronized void sellProduct() {
        if (product>0){
            System.out.println(Thread.currentThread().getName()+":消费产品"+product);
            product--;
            notifyAll();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addProduct() {
        if (product<20){
            product++;
            System.out.println(Thread.currentThread().getName()+":生产产品"+product);
            notifyAll();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + "开始生产产品...");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

class Customer extends Thread {
    private Clerk clerk;

    Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + "开始消费产品...");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sellProduct();
        }
    }
}

