package com.riklionline.list.deduplication;

import com.riklionline.bean.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Deduplication {

    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("折尘",40));
        list.add(new Person("枯度",40));
        list.add(new Person("鸿衍",12));
        list.add(new Person("君楼",33));
        list.add(new Person("鸿衍",12));
        list.add(new Person("枯度",40));

        System.out.println("原集合：" + list);

        LinkedList<Person> linkedList = new LinkedList<>();

        Iterator<Person> iter = list.iterator();
        while (iter.hasNext()){
            Person p = iter.next();
            if (!linkedList.contains(p)) { //重点在这里，Person类必须Override equals()方法
                linkedList.add(p);
            }
        }

        System.out.println("新集合：" + linkedList);

    }

}
