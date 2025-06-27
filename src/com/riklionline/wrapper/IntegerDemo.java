package com.riklionline.wrapper;

/**
 * 基本类型	 包装类
 * -------------------------------
 * byte	   |  Byte
 * boolean |  Boolean
 * char	   |  Character
 * double  |  Double
 * float   |  Float
 * int	   |  Integer
 * long	   |  Long
 * short   |  Short
 * -------------------------------
 * 为什么要用包装类，因为功能多
 */

public class IntegerDemo {

    public static void main(String[] args) {

        //包装类自带了很多Static方法，可直接调用
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        Integer integer1 = new Integer(100);
        Integer integer2 = new Integer("100");

        int i2 = integer2.intValue();//integer ——> int
        System.out.println(i2);

        int i3 = Integer.parseInt("100");//String ——> int
        System.out.println(i3);

        Integer integer3 = Integer.valueOf(100);// int——>integer
        System.out.println(integer3);

        //十进制 ——> 二进制/十六进制
        String binaryString = Integer.toBinaryString(100);
        System.out.println(binaryString);
        String hexString = Integer.toHexString(100);
        System.out.println(hexString);
    }

}
