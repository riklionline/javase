package com.riklionline.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; //Atl + Enter = import
import java.util.ListIterator;

/**
 * listIterator() vs iterator()
 */

public class ListDemo02 {

    public static void main(String[] args) {

        //iterator();

        listIterator();

    }

    private static void iterator() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("rikli");
        list.add("D");
        list.add("E");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("rikli".equals(s)) {
                list.add("online");
            }
        }
        System.out.println(list);
    }

    private static void listIterator() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("rikli");
        list.add("D");
        list.add("E");

        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            String s = listIterator.next();
            if ("rikli".equals(s)) {
                listIterator.add("online");
            }
        }

        System.out.println(list);

        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

    }

}
