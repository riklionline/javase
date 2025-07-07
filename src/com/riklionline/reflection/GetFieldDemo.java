package com.riklionline.reflection;

import java.lang.reflect.Field;

public class GetFieldDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class clazz = Class.forName("com.riklionline.reflection.Animal");

        //获取成员变量名称，"gender" is public variable
        Field gender = clazz.getField("gender");
        System.out.println(gender);

        //获取成员变量类型，"name" is private variable
        Field name = clazz.getDeclaredField("name");
        Class<?> type = name.getType();
        System.out.println(type + " ----> " + name);

        //获取成员变量记录的值
        Animal animal = new Animal("狗",18,"female");
        System.out.println(animal);

        //这里是用反射获取的clazz对象的成员变量gender获取值，应要求clazz类与“当前操作对象”是同一个类
        String value = (String) gender.get(animal);
        System.out.println(value);

        //注意这里用法看起来顺序有些别扭，成员变量.set(object, value)
        gender.set(animal,"male");
        System.out.println(animal);

    }
}
