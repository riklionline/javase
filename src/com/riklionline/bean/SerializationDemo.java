package com.riklionline.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

    public static void main(String[] args) {

        // 1. 准备一个待序列化的对象
        Person person = new Person();
        person.setName("RikliOnline");
        person.setAge(22);

        // 2. 序列化到文件
        String filePath = "person.ser"; // 序列化文件路径

        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(person); // 关键步骤：写入对象
            System.out.println("对象已序列化到文件: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("序列化失败: " + e.getMessage());
        }

    }

}
