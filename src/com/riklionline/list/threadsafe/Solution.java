package com.riklionline.list.threadsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * arraylist与linkedlist都是线程不安全的
 * vector是线程安全的，但是效率中规中矩
 * Collections是类，Collection是接口
 */

public class Solution {

    public List<Integer> getList() {

        List<Integer> list = new ArrayList<>();

        List<Integer> synchList = Collections.synchronizedList(list);

        return synchList;

    }

}
