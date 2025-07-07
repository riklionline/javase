package com.riklionline.reflection.application;

import com.riklionline.reflection.application.bean.Kid;
import com.riklionline.reflection.application.bean.Parent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class SaveObjectMain {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        Kid kid = new Kid("kaka",6,"男",55,121,"吃");
        Parent parent = new Parent("物联网开发",50000);

        saveObject(kid);

    }

    public static void saveObject(Object o) throws IllegalAccessException, IOException {

        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();

        BufferedWriter bw = new BufferedWriter(new FileWriter("person.txt"));

        for (Field field : fields) {
            field.setAccessible(true);
            bw.write(field.getName() + " = " + field.get(o));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
