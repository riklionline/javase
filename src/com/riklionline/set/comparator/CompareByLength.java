package com.riklionline.set.comparator;

import com.riklionline.bean.Person;

import java.util.Comparator;

public class CompareByLength implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        int num = o1.getName().length() - o2.getName().length();

        if(num == 0) {
            num = o1.getName().compareTo(o2.getName());
            if(num == 0) {
                num = o1.getAge() - o2.getAge();
            }

        }
        return num;
    }
}
