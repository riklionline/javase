package com.riklionline.set;

import java.util.TreeSet;

/**
 * TreeSet会自动排序，自动去重
 * 底层使用二叉树结构
 */

public class TreeSetDemo01 {

    public static void main(String[] args) {

        //String，Integer implements java.io.Comparable接口，所以可以排序
        TreeSet<String> ts = new TreeSet<>();

        ts.add("A");
        ts.add("E");
        ts.add("C");
        ts.add("M");
        ts.add("E");
        ts.add("B");
        ts.add("D");

        System.out.println(ts);//[A, B, C, D, E, M]

    }
}
