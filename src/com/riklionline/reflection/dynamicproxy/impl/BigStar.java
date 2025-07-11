package com.riklionline.reflection.dynamicproxy.impl;

import com.riklionline.reflection.dynamicproxy.Star;

public class BigStar implements Star {

    private String name;
    private int age;

    public BigStar() {
    }

    public BigStar(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name + "正在演唱" + name);
        return "谢谢！";
    }

    @Override
    public void dance() {
        System.out.println("开始跳舞");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BigStar{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
