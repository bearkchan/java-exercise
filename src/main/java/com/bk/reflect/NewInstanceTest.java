package com.bk.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Create by bear
 * Date 2021/3/3 4:31 下午
 */
public class NewInstanceTest {
    @Test
    void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> pclass = Person.class;
        Person person = pclass.newInstance();
        System.out.println("person = " + person);
    }

    /**
     * 获取运行时类的带泛型的父类的泛型
     */
    @Test
    void test2(){
        Class<Person> person = Person.class;
        Type[] genericInterfaces = person.getSuperclass().getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            ParameterizedType genericInterface1 = (ParameterizedType) genericInterface;
            Type[] actualTypeArguments = genericInterface1.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                Class typeArgument = (Class) actualTypeArgument;
                System.out.println(typeArgument.getName());
            }
        }
    }
}
