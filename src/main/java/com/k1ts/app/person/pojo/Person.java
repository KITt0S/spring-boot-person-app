package com.k1ts.app.person.pojo;

public class Person {

    private static long lastId;

    private final long id;

    private String name;

    private int age;

    public Person(String name, int age) {
        this.id = lastId;
        this.name = name;
        this.age = age;
        lastId++;
    }

    public long getId() {
        return id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
