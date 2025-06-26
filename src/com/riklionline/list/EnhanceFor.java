package com.riklionline.list;

import java.util.ArrayList;
import java.util.Iterator;

public class EnhanceFor {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        forMethod(list);
        //iteratorMethod(list);
        //enhanceFor(list);

    }

    private static void enhanceFor(ArrayList<String> list) {
        for (String s : list) {
            if ("b".equals(s)) {
                //ConcurrentModificationException，并发修改异常报错
                list.remove(s);
            }
        }
    }

    private static void iteratorMethod(ArrayList<String> list) {
        //iterator
        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            if ("b".equals(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void forMethod(ArrayList<String> list) {
        /*
         * 注意：普通for循环中，包含初始值、循环继续条件、步进
         * 如果循环继续条件是一个方法，则每次循环都会重新执行这个方法，以确定是否需要继续执行循环
         */
        for (int i = 0; i < list.size(); i++) {
            System.out.println("次数：" + i);
            if ("b".equals(list.get(i))) {
                list.remove(i);

                break;
            }
        }
        System.out.println(list);
    }

}
