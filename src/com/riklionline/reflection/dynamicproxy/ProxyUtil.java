package com.riklionline.reflection.dynamicproxy;

import com.riklionline.reflection.dynamicproxy.impl.BigStar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象生成器
 */

public class ProxyUtil {

    public static Star createProxy(BigStar bigStar) {

        /* java.lang.reflect.Proxy类提供了（为一个对象）产生代理对象的方法
         *
         * Proxy.newProxyInstance(ClassLoader, Class<?>[] Interface, InvocationHandler h)
         * 参数 1）：指定一个类加载器，来加载生成的代理类
         * 参数 2）：指定接口，因为原始对象也实现了这个接口，所以代理对象也要实现这个接口的方法，才能使用这个方法
         *          Star.class 表达式返回的是：
                    · 一个 java.lang.Class 类型的对象（字节码）
                    · 描述Star接口的元数据对象（不是接口实例，只需要获取“描述接口”的元数据即可）
                    · JVM 加载Star接口时自动创建的对象
         * 参数 3）：用来指定生成的代理对象要做什么事情
         */

        Star star = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},

                //参数 3)：用来指定生成的代理对象要做什么事情
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                         * 参数 1）：“代理对象”，即star
                         * 参数 2）：要运行的方法，sing
                         * 参数 3）：调用方法传递的实参
                         */
                        if("sing".equals(method.getName())) {
                            System.out.println("准备话筒，收钱");
                        }else if("dance".equals(method.getName())) {
                            System.out.println("准备场地，收钱");
                        }

                        Object o = method.invoke(bigStar, args);

                        return o;
                    }
                });

        return star;

    }
}
