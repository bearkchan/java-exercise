package com.bk.collection;

import java.util.Objects;

/**
 * Create by bear
 * Date 2021/1/20 7:08 下午
 */
public class Animal {
    int id;
    String name;

    public Animal() {
    }

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
