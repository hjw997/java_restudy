package DesignPattern.c_interface_isolation.positive;

public class Brid implements Flyable,Eatable {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }
}
/**
 * 游选择的去实现 自己想要的功能, 不相关的就不要实现.
 * 也可以说 是单一职责.
 * ps:开闭原则 其实也是分: 是把修改和扩展分开.
 */
