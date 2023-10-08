package DesignPattern.c_interface_isolation.negtive;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗游泳--狗刨");
    }

    @Override
    public void fly() {
        throw new RuntimeException("狗不会飞,你行你来~");
    }
}
