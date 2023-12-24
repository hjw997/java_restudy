package mj_java_01.a17_IO.d_io流.h_对象流_支持引用类型的IO操作.b_序列化_反序列化_Serializable标记接口;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    int age;
    String name;

    Car car;

    List<Book> books = new ArrayList<>();

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", car=" + car +
                ", books=" + books +
                '}';
    }
}
