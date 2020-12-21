package com.bk.object;

public class InterfaceTest {
    public static void main(String[] args) {
        new Class1().eat();
    }
}


interface Inte1{
    void eat();
    void fly();
}

abstract class Abstr1{
    abstract void h1();
    abstract void h2();
    void eat(){
        System.out.println("abstract eat");
    };
}

class Class1 extends Abstr1 implements Inte1{

    @Override
    public void eat() {
        System.out.println("class1 eat");
    }

    @Override
    public void fly() {

    }

    @Override
    void h1() {

    }

    @Override
    void h2() {

    }
}
