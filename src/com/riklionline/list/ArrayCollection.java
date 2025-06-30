package com.riklionline.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.sort;

/**
 * @ClassName: ArrayCollection
 * @Descirption: 集合List & 数组Array之间的转换，顺便介绍一个静态导入（方法）的功能
 * @Version: V1.01
 * @Author: RikLi
 * @DateTime: 2025/6/30 1:57 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class ArrayCollection {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        //转化后的数组长度如果 > 集合长度，则多余的位置留空：null
        String[] array = list.toArray(new String[5]);
        System.out.println(array.length);
        for (String s : array) {
            System.out.println(s);
        }

        String[] strings = {"a","b","c"};

        List<String> arrayList = Arrays.asList(strings);
        //arrayList.add("d"); 报错，不支持的操作，因为数组转化的集合不是java集合中的ArrayList类
        System.out.println(arrayList.size());

        //静态导入：StaticImport
        int[] ints = {5,8,2,6,9};
        sort(ints);//静态导入了这个sort方法，所以可以直接使用

        for (int i : ints) {
            System.out.println(i);
        }
    }

}
