package com.bk.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Create by bear
 * Date 2021/1/14 7:47 下午
 */
public class CollectionTest {
    @Test
    void test1() {
        List list = new ArrayList<Object>();
        Person p1 = new Person("xiaomi", 20);
        list.add(p1);
        list.add(p1);
        System.out.println(list.toString());
    }

    @Test
    void test2() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("nihao");
        list.add(new Person("xiaomi", 18));
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

    @Test
    void test3() {
        List<String> list1 = Arrays.asList(new String[]{"AAA", "BBB", "CCC"});
        System.out.println(list1);

        List<int[]> list2 = Arrays.asList(new int[]{1, 2, 3});
        System.out.println(list2);//[[I@cb51256]
        System.out.println(list2.size());//1

        List<Integer> list3 = Arrays.asList(new Integer[]{1, 2, 3});
        System.out.println(list3);//[1, 2, 3]
        System.out.println(list3.size());//3
    }

    @Test
    void test4() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("nihao");
        list.add(new Person("xiaomi", 18));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void test5() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("nihao");
        list.add(new Person("xiaomi", 18));

        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    void test6() {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("xiaomi", 43));
        people.add(new Person("zhangsan", 23));
        people.add(new Person("lisi", 73));
        people.forEach(System.out::println);
    }

    @Test
    void test7() {
        // 定制排序
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        // 使用有参构造器声明比较器
        TreeSet<Person> people = new TreeSet<>(comparator);
        people.add(new Person("xiaomi", 43));
        people.add(new Person("zhangsan", 23));
        people.add(new Person("lisi", 73));
        people.forEach(System.out::println);
    }

    @Test
    void test8() {
        HashSet animals = new HashSet();
        Animal a1 = new Animal(1001, "AA");
        Animal a2 = new Animal(1002, "BB");
        animals.add(a1);
        animals.add(a2);
        // [Animal{id=1002, name='BB'}, Animal{id=1001, name='AA'}]
        System.out.println(animals);

        a1.name = "CC";
        animals.remove(a1);
        // [Animal{id=1002, name='BB'}, Animal{id=1001, name='CC'}]
        System.out.println(animals);

        animals.add(new Animal(1001, "CC"));
        // [Animal{id=1002, name='BB'}, Animal{id=1001, name='CC'}, Animal{id=1001, name='CC'}]
        System.out.println(animals);
        animals.add(new Animal(1001, "AA"));
        // [Animal{id=1002, name='BB'}, Animal{id=1001, name='CC'}, Animal{id=1001, name='CC'}, Animal{id=1001, name='AA'}]
        System.out.println(animals);


    }
}
