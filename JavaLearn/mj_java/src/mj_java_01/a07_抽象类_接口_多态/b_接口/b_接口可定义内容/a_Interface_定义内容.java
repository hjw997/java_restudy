package mj_java_01.a07_抽象类_接口_多态.b_接口.b_接口可定义内容;


/**
 * 接口就是用来定义方法(行为准则)的集合.
 */
public interface a_Interface_定义内容 {

    public abstract void test1();
    /**接口中的抽象方法默认就是抽象的 abstract 可以省略.*/

    /**
     * 接口中可以定义什么?
     * 可以定义:抽象方法,常量,嵌套类型,从java 8 开始可以定义:默认方法,静态方法(类方法)
     */
    public static final int AGE = 10; //java中的常量就是 static final
    /**接口中的 常量 可以省略 public static final .*/

    /**
     * 嵌套类
     */
    public class A {

    }

    /**
     * 上述 可以定义的内容都是 隐式 public 的.
     * 因此可以省略 public 关键字. 所以看到接口中 没写public 人是真 public . 我们自己定义的属性没写是 package-private
     * 接口中的定义的 都是 public的 写其他的访问权限 就会报错. ❌
     */

    /**
     * 接口中不可以定义初始化块 实例初始化块 和 静态初始化块都不可以,接口也不能实例化 不能 new 接口.  ---始终记得接口是用来定义规范的.
     */

}

/**
 * 接口是用来实现的 implements
 */
class Person implements a_Interface_定义内容 {

    @Override
    public void test1() {

    }
}


