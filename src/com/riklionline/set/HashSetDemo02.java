package com.riklionline.set;

import com.riklionline.bean.Person;

import java.util.HashSet;

public class HashSetDemo02 {

    public static void main(String[] args) {

        HashSet<Person> set = new HashSet<>();

        set.add(new Person("rikli", 22));
        set.add(new Person("nikki", 23));
        set.add(new Person("kim", 24));
        set.add(new Person("rikli", 22));//调用Person的equals方法，去重
        set.add(new Person("nikki", 23));//调用Person的equals方法，去重

        for (Person p : set) {
            System.out.println(p);
        }

    }
}
