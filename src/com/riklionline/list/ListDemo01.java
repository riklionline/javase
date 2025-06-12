package com.riklionline.list;

import java.util.ArrayList;
import java.util.List;

/**
 * list实现了collection
 * list特有方法演示
 */

public class ListDemo01 {

    public static void main(String[] args) {

        //listAdd();
        //listSet();
        listGet();

    }

    private static void listGet() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void listSet() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        list.set(1,"Hello");

        System.out.println(list);
    }

    private static void listAdd() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list.size());
        System.out.println(list.indexOf("A")); //结果：0，array和list的索引都是从0开始

        //通过索引添加元素，索引值≥0，并且≤list.size()
        list.add(4,"E");
        System.out.println(list.size());
        System.out.println(list);
    }
}
