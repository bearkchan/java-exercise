package com.bk.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Create by bear
 * Date 2021/1/23 12:20 上午
 */
public class MapTest {
    @Test
    void test1() {
        Map map1 = new HashMap();
        map1.put("aaa", 111);
        map1.put("bbb", 222);
        map1.put("ccc", 333);
        Map map2 = new HashMap();
        map2.put("ddd", 111);
        map2.put("eee", 222);
        map2.put("aaa", 333);
        map1.putAll(map2);
        System.out.println(map1);
    }

    @Test
    void test2() {
        Map map1 = new HashMap();
        map1.put("name", "zhangsan");
        map1.put("age", 12);
        Map map2 = new HashMap();
        map2.put("name", "zhangsan");
        map2.put("age", 12);
        boolean equals = map1.equals(map2);
        System.out.println(equals);
        Set set = map1.entrySet();
        System.out.println(set);
        Set set1 = map2.entrySet();
        System.out.println(set1);
    }

    @Test
    void test3() {
        Map map1 = new HashMap();
        map1.put("name", "zhangsan");
        map1.put("age", 12);
        Set set = map1.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = map1.get(key);
            System.out.println("key = " + key + ",value = " + value);
        }
    }

    @Test
    void test4() {
        Map map1 = new HashMap();
        map1.put("name", "zhangsan");
        map1.put("age", 12);
        Collection values = map1.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println("value = " + value);
        }
    }

    @Test
    void test5() {
        Map map1 = new HashMap();
        map1.put("name", "zhangsan");
        map1.put("age", 12);
        Set set = map1.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key = " + key + ",value = " + value);
        }
    }

    @Test
    void test6() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("AAA", 111);
        linkedHashMap.put("BBB", 111);
        linkedHashMap.put("CCC", 111);
        // linkedHashMap = {AAA=111, BBB=111, CCC=111}
        System.out.println("linkedHashMap = " + linkedHashMap);

        HashMap hashMap = new HashMap();
        hashMap.put("AAA", 111);
        hashMap.put("BBB", 111);
        hashMap.put("CCC", 111);
        // hashMap = {AAA=111, CCC=111, BBB=111}
        System.out.println("hashMap = " + hashMap);
    }
}
