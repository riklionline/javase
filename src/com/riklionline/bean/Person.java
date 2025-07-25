package com.riklionline.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName: Person
 * @Descirption:
 * @Version: V1.01
 * @Author: RikLi
 * @DateTime: 2025/6/7 1:22 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class Person implements Serializable , Comparable<Person> {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("executing person equals method...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {

        System.out.println(this + "CompareTo: " + o);

        int num = this.age - o.age;
        if (num == 0) {
            return this.name.compareTo(o.name);
        }

        return num;
    }
}
