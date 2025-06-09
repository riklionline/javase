package com.riklionline.collection;

import com.riklionline.bean.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
