package com.dean.java8.demo.stream;

/**
 * Created by chenhu on 2018/3/29.
 */
public class BabyBear {
    private String color;
    private int age;
    private float height;
    private String owner;

    public BabyBear(String color, int age, float height, String owner) {
        this.setAge(age);
        this.setColor(color);
        this.setHeight(height);
        this.setOwner(owner);
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
