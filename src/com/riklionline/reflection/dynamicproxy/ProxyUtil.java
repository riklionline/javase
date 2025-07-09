package com.riklionline.reflection.dynamicproxy;

import com.riklionline.reflection.dynamicproxy.impl.BigStar;


public class ProxyUtil {

    public static Star createProxy(BigStar bigStar) {


        Star star = new BigStar();
        return star;

    }

}
