package com.riklionline.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
  Map:{key=value, key=value, ...}
 */

public class MapDemo01 {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        String s1 = map.put(1001, "李连杰");
        String s2 = map.put(1002, "刘德华");
        String s3 = map.put(1003, "成龙");
        //map.put()的返回值是将与key对应的"被替换掉的value"返回
        String s4 = map.put(1003, "房祖名");

        String[] strings = {s1, s2, s3, s4};

        for (String s : strings) {
            System.out.println(s);
        }

        //直接打印map，输出{key=value}，如{1001=李连杰, 1002=刘德华, 1003=房祖名}
        System.out.println(map);

        //return true or false
        System.out.println("Is map contains key '1001':" + map.containsKey(1001));
        System.out.println("Is map contains value '刘德华':" + map.containsValue("刘德华"));

        //map.get()获取到对应key的value做为返回
        System.out.println(map.get(1001));

        System.out.println("Map的容量是:" + map.size());

        Collection<String> values = map.values();
        System.out.println("Map中的value:" + values);

        String s = map.remove(1002);
        System.out.println("The key of'1002' is removed, value is: " + s);
        System.out.println(map);

        map.clear();
        System.out.println(map);

    }
}
