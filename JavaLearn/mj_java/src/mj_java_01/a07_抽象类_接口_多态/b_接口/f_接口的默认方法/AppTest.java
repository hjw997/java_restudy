package mj_java_01.a07_抽象类_接口_多态.b_接口.f_接口的默认方法;

interface JiajiaoAble {
    default void teachBasketBall() {
        System.out.println("JiajiaoAble 教篮球 🏀默认实现");
    }

    default void teachFootBall() {
        System.out.println("JiajiaoAble 教足球 ⚽️默认实现");
    }
}
abstract class Person implements JiajiaoAble {
    /**
     * 当一个类实现的接口中有默认方法时,这个类可以
     * 1.啥也不干,沿用接口的默认实现
     * 2.重新定义默认方法,覆盖默认方法的实现
     */
    @Override
    public void teachFootBall() {
        //JiajiaoAble.super.teachFootBall();
        System.out.println("人类教⚽️的重新定义");
    }
    /**
     * 3.也可以重新声明默认方法,将默认方法声明为抽象方法(那么此类就要变为抽象类)
     */
     public abstract void teachBasketBall();
}

class Student extends Person {
    @Override
    public void teachBasketBall() {
        // 此时就不能调用 接口的 方法了 中间隔着一层 抽象类了
        // JiajiaoAble.super.teachBasketBall();
        // 那么 Student 是不是 JiajiaoAble 类型呢?
        System.out.println("Student 教篮球篮球");
    }
}

/**
 * 当一个接口继承的父接口中有默认实现方法时,这个接口可以:
 * 1.啥也不干,沿用接口的默认实现
 * 2.重新定义默认方法,覆盖默认方法的实现
 * 3.也可以重新声明默认方法,将默认方法声明为抽象方法
 * 如下的 BaomuAble .
 */
interface BaomuAble extends JiajiaoAble {
    @Override
    default void teachBasketBall() { //2.重新定义默认方法,覆盖默认方法的实现
        System.out.println("保姆接口-默认实现:教篮球");
    }

    /**
     * 3.也可以重新声明默认方法,将默认方法声明为抽象方法
     */
    abstract void teachFootBall();
}


public class AppTest {
    public static void main(String[] args) {
        Student student = new Student();
        //那么 Student 是不是 JiajiaoAble 类型呢? 任然是的
        testJiajiaoAble(student);

    }

    public static void testJiajiaoAble(JiajiaoAble jiajiao) {
        jiajiao.teachBasketBall();
        //jiajiao.teachFootBall();
    }
}
