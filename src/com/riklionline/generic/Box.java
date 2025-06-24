package com.riklionline.generic;

// 泛型类示例：一个可包装任意类型的盒子
// 定义类的时候，希望约束其方法参数的类型使其唯一，但是现在不确定需要哪个类型

class Box<T> {
    private T content;
    public void setContent(T content) {
        this.content = content;
    }
    public T getContent() {
        return content;
    }
}

