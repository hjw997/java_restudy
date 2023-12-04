package mj_java_01.a07_抽象类_接口_多态.b_接口.h_接口中的静态方法;


interface Eatable {
    /**
     * 接口中的方法默认都是 public 的.
     */
    static void eat(String name) {
        System.out.println("Eatable -eat -" + name);
    }
}
interface Sleepable {
    static void eat(String name) {
        System.out.println("Sleepable -eat -" + name);
    }
}
interface Dog extends Sleepable , Eatable {
   public static void eat(String name) { //接口中的 静态方法不是重写
        System.out.println("Dog -eat -" + name);
    }
}

class Person {
    public static void run() {
        System.out.println("Person-static-run()");
    }
}

class Student extends Person {
//    public static void run() {
//        System.out.println("Student-static-run()");
//    }
}

public class AppTest {
    public static void main(String[] args) {
        /**
         * 接口中定义的静态方法,只能通过 接口名 调用, 不能被继承 , 类的静态方法, 可以继承给子类.
         *  > 回顾 我们以前类的静态方法可以用对象调用,但是接口不行.
         */
        Dog.eat("1");
        Sleepable.eat("2");
        Eatable.eat("3");

        //类的静态方法, 可以继承给子类.
        Student.run();
        Person.run();

        //而接口的静态方法:在哪个接口就只能通过接口调用.如:
        Sleepable.eat("food");
        Dog.eat("bone");
        //因为类是单继承,可以沿着继承链找到.子类没有就会找父类.
        //接口因为多继承的,就会引起歧义.

        /**
         * PS:java中的重写 指的是 实例的方法.不是静态方法.
         * 看类方法的调用细节章节内容.
         */

    }
}
