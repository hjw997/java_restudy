package mj_java_01.a06_嵌套类.e_局部类;

import javax.security.auth.login.AccountException;

public class 有效final {

    private int count;

    {
        System.out.println("实例代码块 ");
    }
    static {
        System.out.println("静态代码块---");
    }

    public static void staticTest() {
        class LocalClassA {
            void test01() {
                //Non-static field 'count' cannot be referenced from a static context
                //System.out.println(count); 非静态的 count 不能 使用在 静态上下文中.
                /**
                 * 局部类 只能定义在实例相关的代码块中,才能直接访问 外部类中的实例成员 (实例方法,实例变量)
                 */
            }
        }
    }

    /**
     * 局部类 只能定义在实例相关的代码块中,才能直接访问 外部类中的实例成员 (实例方法,实例变量)
     */
    public void test() {
        //局部类只能访问 final 的局部变量.
        final int b = 10;
        //或者 有效 final ,从 java 8 开始 ,如果局部变量没有被第二次赋值,就认定为是有效final .
        int  a = 10 ; // 有效 final
        // a  = 20 ; // 如果这里修改了 a 的值,a 就不是 有效final了 局部类中就会报错;❌

        class LocalClass { //局部类.
            int age = 1;
            void test() {
                System.out.println(a); //a是有效final
                // 这里其实就是可以理解为 捕获外面的值 相当于直接在这里替换了.或者多线程 等会再调用
                System.out.println(10); //为什么非要常量呢? 因为 这个类对象的内存在堆空间, 这个局部代码块执行完就要栈销毁了.

                System.out.println(b); //b是 final

                //局部类可以直接访问外部类中的所有成员(即使被声明为 private)
                // 先有外面的 类的实例,才有内部的局部变量,所以内存存在,所以可以访问.
                System.out.println(count);
            }

        }
        LocalClass localClass = new LocalClass();
        localClass.test();

        //比如这里 函数test执行完了,所以栈帧都会销毁,但是过了一会 这里来个回调 来调用 localClass.test(); 此时 a 所在栈已经销毁了.肯定会出问题. ❌
        // 所以 不会让内部类 直接访问 局部变量的.

       // java 8 开始  才有有效 final 这个概念, 以前必须写 final 修饰.
    }
}
