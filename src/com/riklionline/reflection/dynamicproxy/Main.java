package com.riklionline.reflection.dynamicproxy;

import com.riklionline.reflection.dynamicproxy.impl.BigStar;

public class Main {

    public static void main(String[] args) {

        BigStar bigStar = new BigStar("刘德华",18);
        Star proxy = ProxyUtil.createProxy(bigStar);

        String result = proxy.sing("十八岁");
        System.out.println(result);

        proxy.dance();

    }

}
