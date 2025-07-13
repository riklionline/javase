package com.riklionline.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射的作用：
 * 1.可以实现反编译，.class->java
 * 2.通过反射机制获取类的属性、方法等
 * ---------------------------------------------------------------------
 * 类的全生命周期：Loading->Link[Verification->Preparation->Resolution]->Initialization->Using->Unloading
 * 加载阶段：查找并读取类文件二进制数据
 * 验证阶段：验证类文件格式正确性
 * 准备阶段：为静态变量分配内存并设默认值
 * 解析阶段：将符号引用转为直接引用
 * 初始化阶段：执行静态代码块和静态变量初始化
 * ----------------------------------------------------------------------
 * Class.forName()相当于 forName(className, true, currentLoader)，主要在类加载过程的"初始化"阶段(Initialization)执行
 * 如果参数为：forName(className, false, loader)，则只执行到准备阶段
 */

public class GetClazzDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        /*
         * 以下是三种获取.class(字节码文件)的Class对象，当JVM把.class文件读取到内存时，都会在内存中创建这个.class的一个Class对象（唯一）
         * Class类是java.lang下的一个jdk自带的类
         * 输出结果都是：class com.riklionline.reflection.Animal，
         * clazz1、clazz2、clazz3都指向同一个内存地址，说明Animal在运行时只创建了一个Class对象
         * 注意区分：这个Class对象与 new Animal()不是一个，Class对象是描述一个类的对象，而new Animal()是对象实例
         */

        //1.最常用，Class.forName()，静态方法 ("com.riklionline.reflection.Animal")
        Class<?> clazz1 = Class.forName("com.riklionline.reflection.Animal");
        //注意：假设src目录下没有Flower.java类，编译后字节码文件生成在out目录（Flower.class），而后手动删除了Flower.java类
        Class<?> flowerClass = Class.forName("com.riklionline.reflection.Flower");
        System.out.println(clazz1);
        System.out.println(flowerClass.getName());//验证反射机制确实是从.class文件加载到内存后开始工作

        //2.常用于当作参数传递，synchronized(Animal.class)
        Class<Animal> clazz2 = Animal.class;
        System.out.println(clazz2);

        //3.有对象实例时，可以使用animal.getClass()
        Animal animal = new Animal();
        Class<?> clazz3 = animal.getClass();
        System.out.println(clazz3);

    }
}
