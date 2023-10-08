package DesignPattern.c_interface_isolation.positive;

public class Dog implements Eatable,Swimable {

    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗游泳--狗刨");
    }
}

/// 这里 Dog 就有选择的去实现 自己的功能.
