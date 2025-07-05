package com.riklionline.set;

import com.riklionline.bean.Person;
import java.util.TreeSet;

/**
 * TreeSet会自动排序，自动去重
 * 底层使用二叉树结构
 */

public class TreeSetDemo02 {

    public static void main(String[] args) {

        TreeSet<Person> ts = new TreeSet<>();

        //new一个Person对象的时候，会自动调用Person中的 compareTo(Person o)，但是"o"是谁要依据系统排序的机制（如二叉树）决定
        ts.add(new Person("A", 25));
        ts.add(new Person("D", 19));
        ts.add(new Person("B", 19));
        ts.add(new Person("W", 18));

        System.out.println(ts);

    }

}
