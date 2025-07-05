package com.riklionline.set.comparator;

import com.riklionline.bean.Person;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Person> ts = new TreeSet<>(new CompareByLength());

        ts.add(new Person("rik", 18));
        ts.add(new Person("weston", 19));
        ts.add(new Person("john", 19));
        ts.add(new Person("dannel", 29));
        ts.add(new Person("dannel", 30));


        System.out.println(ts);

    }

}
