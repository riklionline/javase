package com.riklionline.collection;

import com.riklionline.bean.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * iterator相当于在集合对象的基础之上套了一层工具壳，这个壳带有遍历内部元素的功能（指针）
 */


public class IteratorDemo01 {

    public static void main(String[] args) {

        iteratorDemo();

    }

    //方法抽出快捷键：crtl+alt+M
    private static void iteratorDemo() {
        Collection<Person> c = new ArrayList<>();

        c.add(new Person("张三",20));
        c.add(new Person("王五",19));
        c.add(new Person("赵六",19));
        c.add(new Person("李四",19));

        Iterator<Person> iterator = c.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
