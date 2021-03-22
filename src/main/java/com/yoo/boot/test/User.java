package com.yoo.boot.test;

import lombok.Data;

@Data
public class User {

    private int id;
    private  String name;
    private String address;
    private int age;
    private String phoneNum;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}