package DesignPattern.c_interface_isolation.negtive;

public class Bird implements Animal {

    @Override
    public void eat() {
        System.out.println("鸟吃虫子");
    }

    @Override
    public void swim() {
        throw new RuntimeException("You can you up~");
    }

    @Override
    public void fly() {
        System.out.println("鸟会飞~~~~~");
    }
}
