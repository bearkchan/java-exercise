package com.bk.object;

/**
 * 单列模式
 */
public class SingleTonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println("(bank1==bank2) = " + (bank1 == bank2));
    }



}


/**
 * 饿汉模式
 */
class Bank{
    // 1. 设定构造函数为私有的
    private Bank(){}
    // 2. 设置static变量存放对象
    private static Bank bank = new Bank();
    // 3. 创建static方法调用静态对象
    public static Bank getInstance(){
        return bank;
    }
}


/**
 * 懒汉式
 */
class Bank2{
    private Bank2(){};
    private static Bank2 bank2 = null;
    public static Bank2 getInstance(){
        if (bank2==null){
            bank2 = new Bank2();
        }
        return bank2;
    }
}
