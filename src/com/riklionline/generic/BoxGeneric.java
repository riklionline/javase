package com.riklionline.generic;

public class BoxGeneric {

    public static void main(String[] args) {

        Box<String> boxStr = new Box<>();
        boxStr.setContent("Hello");

        //问题，父类引用指向子类对象的时候，new后面的对象的类型可能与前面引用的类型不一致吗？
        Box<Integer> boxInt = new Box<>();
        boxInt.setContent(123);


    }

}
