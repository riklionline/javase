package com.riklionline.wrapper;

public class AutoBoxDemo {

    public static void main(String[] args) {

        //自动装箱：即基本数据类型（裸奔的）转化为包装类（带壳的）
        Integer i1 = 10;

        //自动拆箱：即包装类转化为基本数据类型，去壳
        int i2 = i1;

        //Java 为了优化性能，对小范围的 Integer（-128 到 127）做了缓存（IntegerCache，在堆内存的整型常量池），在这个范围内相同的数值会复用对象
        Integer i3 = 200;//相当于new Integer(200)，在堆中是两个对象，两个内存地址
        Integer i4 = 200;
        System.out.println(i4 == i3);

        //Integer类已经重写了equals方法
        System.out.println(i3.equals(i4));

    }

}
