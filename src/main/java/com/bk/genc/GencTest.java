package com.bk.genc;

import java.util.List;

/**
 * Create by bear
 * Date 2021/2/2 11:54 下午
 */
public class GencTest {
    public static void main(String[] args) {

    }

   public static void addStrings(List<? extends Object> list){
        //list.add(new A());
        //list.add(new Object());
   }

   public void addString(List<? super Object> list){
       list.add(new A());
       list.add(new Object());
   }
}
