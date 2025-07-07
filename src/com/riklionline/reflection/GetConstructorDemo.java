package com.riklionline.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class GetConstructorDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 获取到字节码文件对象
        Class<?> clazz = Class.forName("com.riklionline.reflection.Animal");

        Constructor[] constructors = clazz.getConstructors();

        for (Constructor constructor : constructors) {
            //System.out.println(constructor);

        }

        /* 疑问：参数为什么要传递".class"?
         * 使用".class"的形式，核心作用是"精确"指定参数类型。这是Java类型系统在反射中的延续
         * "String.class"相当于"java.lang.String", 直接使用"String"本质上也是"java.lang.String"
         */
        Constructor<?> cons = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(cons);

        //进一步获取构造器的参数类型
        Parameter[] parameters = cons.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        //使用构造方法创建对象
        cons.setAccessible(true);//暴力反射：反射API提供了临时性的突破类的权限修饰符的限制的能力(如 private)，需谨慎使用
        Animal animal = (Animal) cons.newInstance("猫咪", 22);
        System.out.println(animal);

    }
}
