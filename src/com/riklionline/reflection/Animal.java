package com.riklionline.reflection;

public class Animal {

    private String name;
    private int age;
    public String gender;

    public Animal() {
    }

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private String eat(String food) {
        System.out.println("Eating..." + food);
        return "I'm full.";
    }

    public void sleep(){
        System.out.println("The animal is go to sleeping...");
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
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age + '\''+
                ", gender='" + gender + '\'' +
                '}';
    }
}
