package mj_java_01.a17_IO.d_io流.h_对象流_支持引用类型的IO操作.b_序列化_反序列化_Serializable标记接口;

import java.io.Serializable;

public class Book implements Serializable {
    double price;
    String name;

    public Book(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
