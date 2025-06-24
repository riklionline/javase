package com.riklionline.generic;

import com.riklionline.bean.Person;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型，即“参数化类型”；
 * 泛型<E>在jdk7以后可以使用菱形写法，new Class<>中不必显示声明类型
 * 约束集合中元素的类型有很多好处:
 *          1)首先是编译器可以发现错误;
 *          2)其次是如果不用泛型就必须在遍历过程对类型进行判断，性能差。
 */
public class GenericDemo01 {

    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("rikli", 18));
        list.add(new Person("nikkidu", 16));

        Iterator<Person> iterator = list.iterator();

        while (iterator.hasNext()) {
            Person p = iterator.next();
            System.out.println(p);
        }

    }

}
