package com.riklionline.set.linkedhashset;

import java.util.HashSet;
import java.util.Random;

/**
 * 从0~20中生成10个不重复的数
 * hashset不存重复的元素，可以实现自动去重
 */
public class Exercise01 {

    public static void main(String[] args) {

        HashSet<Integer> hs = new HashSet<>();
        Random r = new Random();
        int i;

        while (hs.size() < 10){
            //[0~20) 不含20
            i = r.nextInt(20);
            hs.add(i);
        }

        System.out.println("size: " + hs.size());
        System.out.println(hs);
    }

}
