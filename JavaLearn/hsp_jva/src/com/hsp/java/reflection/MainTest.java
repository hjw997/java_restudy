package com.hsp.java.reflection;

public class MainTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String fullPath = "com.hsp.java.reflection.Car";
        ///<?> 代表什么？代表不确定的Java类型 意思是什么类型的类对象
        Class<?> aClass = Class.forName(fullPath);
        System.out.println(aClass);

    }
}
