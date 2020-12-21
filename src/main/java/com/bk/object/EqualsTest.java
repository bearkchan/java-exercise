package com.bk.object;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class EqualsTest {

    @Test
    void testAutoEqualsFunctions(){
        Person person = new Person();
        Man man = new Man();
        person.age=20;
        person.name="Tom";

        man.age=20;
        man.name="Tom";

        boolean isMan = person.equals(man);
        System.out.println("isMan = " + isMan);
    }
}


class Person{
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Man extends Person{
    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
