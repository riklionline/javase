package com.riklionline.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        //匿名内部类
        Consumer<String> consumer1 = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<Integer> consumer2 = new Consumer<Integer>(){

            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };

        //lambda表达式，注意箭头符号是单横线"->"，区别于vue和js的"=>"
        Consumer<String> consumer3 = (s) -> {
            System.out.println(s);
        };

        consumer1.accept("Hello");
        consumer2.accept(16598745);
        consumer3.accept("World");

    }
}
