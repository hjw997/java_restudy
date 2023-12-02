package mj_java_01.a05_static_final.a_static;

class Person {
    /**
     * static 一般放在权限的后面.
     * static 修饰成员变量 叫做: 类变量, 静态变量, 静态字段(static field)
     *                 在程序运行过程中只占用一份固定的内存(存储在方法区)
     */
    public static int count;

    /**
     * 没有被 static 修饰的叫做实例变量,在每个实例变量的内部都有自己的一份(堆内存)
     */
    public int age;

    /**
     * 被 static 修饰的方法 : 类方法,静态方法.
     */
    public static void run() {
        /** 内部不可以使用this.
         * 静态方法中是没有传入this进来,所以是不能访问实例属性和方法的.
         * 不能使用实例属性和方法的本质:实例方法第一个隐藏的参数是实例对象this. 实例属性在堆中.
         */
        //this.age = 0 //静态方法中的this是没有办法推断出是哪个对象.

    }

    public Person() {
        count++;
    }

    public void speak() {
        /**实例方法可以访问静态属性和方法*/
        run();
        System.out.println(count);
    }

}


public class AppTest {
    public static void main(String[] args) {
        /**类变量就通过 类名.类变量 去访问*/
        Person.count = 10;
        Person.run(); //可以通过类名区访问.

        Person person = new Person();
        person.count = 20; /**实例对象 也能访问 类变量 ,但是不推荐❌. 类变量就通过 类名.类变量 去访问.*/
        person.run();//对象也可以访问静态方法,
    }
}
