package mj_java_01.a06_嵌套类.d_静态内部嵌套类;


/**
 * Car1 和 Person1 就是顶级类.
 */
class Person1 { }
class Car1 {}

class Person {
    private int age;
    private static int COUNT = 1;

    private static void run() {

    }

    /**
     * 静态嵌套类: 被 static 修饰的嵌套类:
     * 静态嵌套类在 行为上就是一个顶级类,只是定义的代码写在了另一个类中
     *
     * 对比一般的顶级类,静态嵌套类多了一些特殊权限.
     * > 可以直接访问外部类中成员(即使被声明为 private)
     * > 除实例方法 和 实例变量 为何? 因为静态的 里面是不能访问实例对象里面的成员和方法. 因为Car对象存在时候,可能Person对象不存在
     */
    public static class Car {
        public void showCar() {
            System.out.println(COUNT); //可以访问 外部的 COUNT.
            run(); //特殊优待可以访问私有静态方法.
            //System.out.println(age); //❌这种是因为 对象都不能保证存在. 怎么访问堆内存呢?
            //PS这样是可以也算是特殊待遇把
            Person person = new Person();
            System.out.println(person.age); //可以访问 一个外部类 实例的 私有属性.
        }
    }
}


public class AppTest {
    public static void main(String[] args) {
        //静态嵌套类 没有外部类实例是可以创建的. 不依赖外部类的实例对象.
        Person.Car car = new Person.Car();
    }
}


