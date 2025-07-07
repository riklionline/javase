package com.riklionline.reflection.application.bean;

public class Parent {

    private String occupation;
    private int salary;

    public Parent() {
    }

    public Parent(String occupation, int salary) {
        this.occupation = occupation;
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "occupation='" + occupation + '\'' +
                ", salary=" + salary +
                '}';
    }

}
