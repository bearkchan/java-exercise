package com.bk.date;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Create by bear
 * Date 2021/1/10 11:29 上午
 */
public class ComparableTest {
    public static void main(String[] args) {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("钢笔", 13.5);
        goods[1] = new Goods("铅笔", 2.5);
        goods[2] = new Goods("铅笔B", 1.5);
        goods[3] = new Goods("毛笔", 8);
        //Arrays.sort(goods);
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return -Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        //[Goods{name='钢笔', price=13.5}, Goods{name='毛笔', price=8.0}, Goods{name='铅笔', price=2.5}, Goods{name='铅笔B', price=1.5}]
        System.out.println(Arrays.toString(goods));
    }
}


class Goods implements Comparable<Goods> {
    private String name;
    private double price;

    @Override
    public int compareTo(Goods o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
