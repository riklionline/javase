package com.riklionline.collection;

import com.riklionline.bean.Person;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName: CollectionDemo02
 * @Descirption: Collection中存放自定义数据类型【对象】
 * @Version: V1.01
 * @Author: RikLi
 * @DateTime: 2025/6/7 1:30 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class CollectionDemo02 {

    public static void main(String[] args) {

        //父类引用指向子类对象（多态）
        Collection<Person> c = new ArrayList<>();

        c.add(new Person("折尘",38));
        c.add(new Person("君楼",30));
        c.add(new Person("古凰",35));
        c.add(new Person("枯度",40));

        System.out.println(c.size());

        Object[] o = c.toArray();
        for (Object object : o) {
            System.out.println(object);
        }

        System.out.println(c);

        Person p = new Person("枯度",40);
        System.out.println(c.contains(p));

        c.remove(p);
        System.out.println(c);

        c.clear();
        System.out.println(c.isEmpty());

    }

}
