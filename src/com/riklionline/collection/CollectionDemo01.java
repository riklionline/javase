package com.riklionline.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * collection method
 * boolean add(E e) //elements
 * boolean remove(Object o)
 * void clear()
 * boolean contains(Object o)
 * boolean isEmpty()
 * int size()
 */

public class CollectionDemo01 {

    public static void main(String[] args) {

        //父类引用指向子类对象
        Collection<String> c = new ArrayList<>();

        //boolean add(E e)
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");

        System.out.println(c);
        System.out.println(c.size());

        //集合转数组返回数据类型为Object
        Object[] o = c.toArray();
        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i]);
        }

        //boolean remove(Object o)
        c.remove("b");
        System.out.println(c);
        System.out.println(c.contains("d"));

        //void clear()
        c.clear();
        System.out.println(c);
        System.out.println(c.isEmpty());



    }


}
