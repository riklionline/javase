package com.riklionline.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: HashSetDemo01
 * @Descirption:
 * @Version: V1.01
 * @Author: RikLi
 * @DateTime: 2025/7/1 9:53 AM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class HashSetDemo01 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        boolean result1 = set.add("abc");
        boolean resust2 = set.add("abc");
        set.add("m");
        set.add("c");
        set.add("d");
        set.add("b");

        System.out.println(result1);
        System.out.println(resust2);

        System.out.println(set);

        //set是无序的，并非按照add的顺序进行存储
        for (String s : set) {
            System.out.println(s);
        }

    }
}
