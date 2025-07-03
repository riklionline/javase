package com.riklionline.set.linkedhashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 将list中的元素去重
 * LinkedHashSet存取顺序一致，且不重复
 */

public class Exercise02 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        list.add("E");
        list.add("B");
        list.add("D");
        list.add("F");
        list.add("C");

        HashSet<String> lhs = new LinkedHashSet<>();
        lhs.addAll(list);
        list.clear();
        list.addAll(lhs);

        System.out.println(list);

    }
}
