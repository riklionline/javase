package com.riklionline.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName: CollectionDemo03
 * @Descirption: Collection中All方法
 *               boolean addAll(Collection c)
 *               boolean removeAll(Collection c)
 *               boolean containsAll(Collection c)
 *               boolean retainAll(Collection c) //取交集

 */

public class CollectionDemo03 {

    public static void main(String[] args) {

        retainAll();

    }

    public static void retainAll() {
        Collection<String> c1 = new ArrayList<>();
        Collection<String> c2 = new ArrayList<>();

        c1.add("a");
        c1.add("b");
        c1.add("c");

        c2.add("a");
        c2.add("b");
        c2.add("c");
        c2.add("e");
        c2.add("f");
        c2.add("g");

        //c1与c2取交集，并移除c1中其他元素（只保留交集），并返回true，如果c1没有进行删减操作，则返回false
        System.out.println(c1.retainAll(c2));
        System.out.println(c1);
    }

}
