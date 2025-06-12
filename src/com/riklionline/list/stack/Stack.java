package com.riklionline.list.stack;

import java.util.LinkedList;

public class Stack {

    private LinkedList<Object> linkedList = new LinkedList<>();

    //压栈
    public void push(Object o) {
        linkedList.addFirst(o);
    }

    //弹栈
    public Object pop() {
        return linkedList.removeFirst();
    }

    //判断栈元素是否为空
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

}
