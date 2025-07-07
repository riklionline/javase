package com.riklionline.reflection.application;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class DynamicObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Properties prop = new Properties();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("reflect.properties"));
        prop.load(bis);
        bis.close();
        System.out.println(prop);

        String className = prop.getProperty("classname");
        String methodName = prop.getProperty("method");

        //动态的根据类名创建对象实例
        Class<?> clazz = Class.forName(className);
        Constructor<?> cons = clazz.getConstructor();
        Object o = cons.newInstance();
        System.out.println(o);

        Method method = clazz.getDeclaredMethod(methodName);

        //继续调用新建对象实例的成员方法（注意在反射机制里，成员方法与对象是分开创建的，所以理论上存在对应不上的可能，要靠代码开发保证）
        method.invoke(o);

    }
}
