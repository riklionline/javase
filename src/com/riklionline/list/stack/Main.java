package com.riklionline.list.stack;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        while (!stack.isEmpty()){

            System.out.println(stack.pop());

        }


    }

}
