package com.riklionline.list;

import java.util.LinkedList;

/**
 * LinkedList（链表）特有方法
 */

public class LinkedListDemo01 {

    public static void main(String[] args) {


        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        linkedList.addLast("rikli");

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.get(3));

    }

}
