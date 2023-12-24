package mj_java_01.a15_泛型_Generic.c_限制类型参数.a_类型参数的基础知识;

import org.junit.Test;

public class AppTest {
    @Test
    public void test01() {
        Person<Double> p1 = new Person<>(18.7);
        System.out.println(p1.getAge());

        Person<Integer> p2 ;
        //Person<String> p3; //报错 ❌这就是 加了 限制类型参数的好处,别人不会传牛鬼蛇神进来.
    }

    /**
     * 可以同时添加多个限制 测试案例.
     */
    @Test
    public void test02() {

        Student<A> stu1 = new Student<>();
        Student<A_B> stu2 = new Student<>();

    }
}

/** ✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅
 * 可以通过 extends 对类型参数增加一些限制条件,比如 < T extends A>
 *   extends 后面可以加上类名,接口名.
 *   加类名:代表T 必须是 A 类型 或者 A类型的子类.
 *   加接口:代表T 必须是 实现了A接口.
 * @param <T>
 */
class Person<T extends Number> {
    private T age;

    public Person(T age) {
        this.age = age;
    }
    public int  getAge() {
        return (age == null) ? 0 : age.intValue();
    }
}

/**
 * 可以同时添加多个限制,比如: < T extends A & B & C > 代表 T 必须同时满足 A,B,C
 * A类或者A的子类,并且同时实现 B接口和C 接口
 * 如果 有 类,就必须放在 第一个位置 A 在接口的前面 .因为 java 不支持多继承
 *
 */
class A implements B,C {
    public void testA() {

    }

    @Override
    public void testB() {

    }

    @Override
    public void testC() {

    }
}
class A_B extends A implements B , C {

    @Override
    public void testB() {

    }

    @Override
    public void testC() {

    }

    public void testAB() {

    }
}

interface B {
    void testB();
}
interface C{
    void testC();
}

class Student<T extends A & B & C>{
    private T age;

    public void setAge(T age) {
        this.age = age;

        // age 点的时候 方法提示会是 A B C 中的方法.
        // age.
    }
}

