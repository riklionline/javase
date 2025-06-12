package com.riklionline.list;

import java.util.Enumeration;
import java.util.Vector;

public class VertorDemo01 {

    public static void main(String[] args) {

        Vector<String> v = new Vector<>();
        v.add("A");
        v.add("B");
        v.add("rikli");
        v.add("D");

        Enumeration<String> e = v.elements();

        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

    }

}
