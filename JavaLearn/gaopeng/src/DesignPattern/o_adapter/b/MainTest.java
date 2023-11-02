package DesignPattern.o_adapter.b;

class A { }
class B extends A{}

class C {}

interface ID{}
class F extends A implements ID{}
class E implements ID{}

public class MainTest {
    public static void testFn(A a) {

    }
    public static void testFnInterface(ID d){}


    public static void main(String[] args) {
        testFn(new B()); //不能传入非继承体系 new C()

        /// 只要是实现了接口的类都可以
        testFnInterface(new E());
        testFnInterface(new F());
    }
}


/**
 * 一个方法的参数是类,而不是接口, 那么这个参数只能使用这个类及其子类,如果这个参数传的不是这个类的子类那么就会报错.
 */