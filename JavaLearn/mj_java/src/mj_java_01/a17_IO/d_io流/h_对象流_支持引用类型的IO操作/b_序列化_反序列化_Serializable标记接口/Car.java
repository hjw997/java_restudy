package mj_java_01.a17_IO.d_io流.h_对象流_支持引用类型的IO操作.b_序列化_反序列化_Serializable标记接口;

import java.io.Serializable;

public class Car implements Serializable {
    double price;
    String band; //品牌

    public Car(double price, String band) {
        this.price = price;
        this.band = band;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", band='" + band + '\'' +
                '}';
    }
}
