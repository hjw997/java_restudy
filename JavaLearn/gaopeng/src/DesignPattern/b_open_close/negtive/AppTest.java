package DesignPattern.b_open_close.negtive;



public class AppTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("奔驰");
        car.setColor("黑色");
        car.setLouyou(true);
        car.setPrice(66666);
        System.out.println(car);
    }
}

/// 变化来了:现在所有汽车,某个节日上 需要打8折.
//  违反开闭原则的做法就是,在getPrice 方法直接修改.
