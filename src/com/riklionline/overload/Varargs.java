package com.riklionline.overload;

public class Varargs {
    public static void main(String[] args) {
        int sum = print(2,10,"Hello","World");
        System.out.println(sum);
    }

    //可变参数，只能有一个，只能放最后，相当于数组（长度不固定），只能存放一种数据类型
    public static int print(int a, int b, String... strArr) {
        //[Ljava.lang.String; [:表示数组，L:表示对象
        System.out.println(strArr.getClass().getName());

        System.out.println("可变参数长度：" + strArr.length);
        for (String str : strArr) {
            System.out.println(str);
        }
        return a+b;

    }
}
