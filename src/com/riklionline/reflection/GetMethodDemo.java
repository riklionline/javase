package com.riklionline.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethodDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?> clazz = Class.forName("com.riklionline.reflection.Animal");

        //获取类中全部方法
        /*Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

        //获取指定方法（根据方法名和方法形参类型）
        Method eatMethod = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(eatMethod);
        System.out.println(eatMethod.getName());

        System.out.println(eatMethod.getParameterCount());

        //运行方法 method.invoke("调用者"，"参数")
        Animal animal = new Animal(); //new一个调用者实例，其类型与反射机制获取的方法所属的类应是同一类
        eatMethod.setAccessible(true); //暴力反射，private方法不允许外部调用

        //在此之前获取到的eatMethod方法对象是静态的，若想执行可使用.invoke()方法，本质上调用的还是原始类的方法，故用invoke表示比较准确
        Object result = eatMethod.invoke(animal, "汉堡");
        System.out.println(result);

    }
}
