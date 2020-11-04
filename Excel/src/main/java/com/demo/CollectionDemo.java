package com.demo;

import java.util.*;

/**
 * @Pragram:CollectionDemo
 * @Description:TODO
 * @Author:ZhuShiQiang
 * @Create:2020-06-28 13:05:12
 **/
public class CollectionDemo {

    public static void testSet(){
        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
//        set.remove("one");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public static void main(String[] args) {
        testSet();
    }
}
