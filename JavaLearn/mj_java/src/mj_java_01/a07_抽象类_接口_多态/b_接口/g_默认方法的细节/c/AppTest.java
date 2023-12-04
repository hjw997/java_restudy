package mj_java_01.a07_抽象类_接口_多态.b_接口.g_默认方法的细节.c;

/**
 * 如果 (父)接口定义的默认方法与其他(父) 接口 定义的方法相同时,要求子类型 实现默认方法
 */
interface Runnable {
    default void run() {
        System.out.println("Runnable - run");
    }
}
interface Walkable {
    default void run() {
        System.out.println("Walkable - run");
    }
}

/**
 * 子接口的情况:
 */
interface Testable extends Runnable,Walkable {
    /**
     * 要求 子接口 必须实现这个相同的默认方法. :因为编译器不知道你要选哪个
     */
    @Override
    default void run() {
        Runnable.super.run();
        Walkable.super.run();
    }
}

/**
 * 子类情况:
 */
class Dog implements Runnable,Walkable {
    /**
     * 要求 子接口 必须实现:因为编译器不知道你要选哪个
     */
    @Override
    public void run() {
        //可以通过 接口.super 调用 两个接口中的默认实现.
        // Runnable.super.run();
         Walkable.super.run();

        System.out.println("Dog -- run");
    }
}


public class AppTest {
    public static void main(String[] args) {
        Walkable walkable = new Dog();
        walkable.run();

    }
}
