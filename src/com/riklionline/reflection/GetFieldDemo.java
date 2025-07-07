package com.riklionline.reflection;

import java.lang.reflect.Field;

public class GetFieldDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class clazz = Class.forName("com.riklionline.reflection.Animal");

        //"gender" is public variable
        Field gender = clazz.getField("gender");
        System.out.println(gender);

        //"name" is private variable
        Field name = clazz.getDeclaredField("name");
        Class<?> type = name.getType();
        System.out.println(type + " ----> " + name);

    }

}
