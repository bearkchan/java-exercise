package com.bk.reflect;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create by bear
 * Date 2021/3/4 7:20 上午
 */
public class ProxyTest {
    public static void main(String[] args) {
        Man man = new Man();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(man);
        proxyInstance.eat("fish");
        proxyInstance.say();
    }
}


interface Human {
    void eat(String food);

    void say();
}


/**
 * 创建被代理对象Man
 */
class Man implements Human {

    @Override
    public void eat(String food) {
        System.out.println("Man is eating " + food);
    }

    @Override
    public void say() {
        System.out.println("Man is saying");
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(object);
        Object proxyInstance = Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                myInvocationHandler
        );
        return proxyInstance;
    }
}

class MyInvocationHandler implements InvocationHandler {
    Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(object, args);
        return returnValue;
    }
}
