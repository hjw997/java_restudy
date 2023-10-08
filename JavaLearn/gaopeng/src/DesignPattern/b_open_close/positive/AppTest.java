package DesignPattern.b_open_close.positive;


public class AppTest {
    public static void main(String[] args) {
        Car car = new DiscountCar();
        car.setBrand("奔驰");
        car.setColor("黑色");
        car.setLouyou(true);
        car.setPrice(66666);
        System.out.println(car);
    }
}

/// 变化来了:现在所有汽车,某个节日上 需要打8折.
//  符合开闭原则是: 写一个子类去扩展, 而不是去修改 被人写的源代码. 虽然是用了继承 ,但是 保证了不去动别人的代码.

