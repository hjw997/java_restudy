package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.e_方法引用_简化lambda.b_引用特定对象的实例方法;


import org.junit.Test;

import java.io.PrintStream;

@FunctionalInterface
interface Testable { //函数式接口
    void test(int v1);
}
class Person {
    public void setAge(int age) {
        System.out.println("Person -setAge - " + age);
    }
}
public class AppTest {


    /**
     *
     * @param testable 这里传入一个接口对象.
     * @param v
     */
    static void execute(Testable testable, int v) {
        testable.test(v);
    }

    public static void main(String[] args) {

        /**
         * 2.引用特定对象的实力方法
         */
        execute(v -> System.out.println(v), 20);
        // 揭秘System.out.println()
        PrintStream printStream = System.out; //System.out 是个对象
        printStream.println("揭秘System.out.println()");
        // System.out.println() 是个对象方法:
        //所以: 简化上面的lambda 表达式 System.out 是个对象
        execute(System.out::println, 20);

        // 创建一个人对象,调用人的setAge
        execute(v -> new Person().setAge(v) , 25);
        // 使用特定对象的引用就是: new Person()是个特定对象 ,然后 ✅ 具体的对象::实例方法
        execute( new Person()::setAge , 25);

    }

}
