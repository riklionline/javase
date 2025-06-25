package com.riklionline.generic;

import com.riklionline.bean.Person;
import com.riklionline.bean.Student;
import java.util.ArrayList;

/**
 * ? super E: 向上限定
 * ? extends E: 向下限定
 */

public class GenericDemo02 {

    public static void main(String[] args) {

        //泛型通配符（?）
        ArrayList<?> list = new ArrayList<>();

        ArrayList<Person> p = new ArrayList<>();

        p.add(new Person("rikli",22));
        p.add(new Person("nikki",21));
        p.add(new Person("kris",33));

        ArrayList<Student> s = new ArrayList<>();

        s.add(new Student("candy",22));
        s.add(new Student("eric",44));

        //addAll(Collection<? extends E> c) ,向下限定
        p.addAll(s);

        System.out.println(p);

    }

}
