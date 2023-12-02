package mj_java_01.a05_static_final.e_final;


/**
 * final : 最终的
 * 1.被 final 修饰的类 不能被子类化,也就是不能被继承. (我不希望继承)
 * 如 jdk 中的 String
 *      public final class String
 */
final class  Person { //final 关键字是在被修饰的 前面.

}

/*** 1.被final修饰的类不可继承*/
//class Student extends Person { } //❌

class Animal {
    private static int count;

    /**
     * 2.  被 final 修饰的方法 不可以被重写
     */
    public final int getCount() {return count;}
    public Animal() { count++; }
}
class Dog extends Animal {
    /**
     * 2.final 修饰的方法不可以被重写.
     */
//    @Override
//    public int getCount() {
//        return super.getCount();
//    }
}

/**
 * 3. final 修饰的变量:
 *    a.局部变量
 *    b.成员变量
 */
class Cat {

    public void testFinal() {
        int age = 10 ;
        age = 20;
        /**
         * final 修饰的变量 只能进行一次赋值.
         */
        final int no;
        no = 10;
    }
    /**
     * 如果 final修饰的 是成员变量的话,要求这个对象创建完必须有值.
     * 那么就可以三个地方 给 final的成员变量赋值.
     *  a.直接申明时候赋值
     *  b.初始化块中
     *  c.构造方法中
     */
    private final int age1 = 10;
    private final int age2;
    /**初始化块中 给 final的成员变量赋值 */
    {
        age2 = 100;
    }

    private final int age3;
    public Cat(int age) { /**构造方法中 给 final 修饰的 */
        age3 = age;

    }

    /**
     * 只要是变量 无论成员变量还是类变量 都可以用 final 修饰
     */
    public static final int age4 = 0;
    public static final int age5;
    /**静态初始化块中 初始化 其实就是类对象有的时候 就要有初始化 */
    static {
        age5 = 10;
    }

    /**
     * java 中的常量(Constant)  指的 是 static final 修饰的
     * 至于是 公共常量  私有常量  看你自己需求.
     */
    public static final double PI1= 3.1415926; //公共常量
    private static final double PI2 = 3.1415926; //私有常量

    /**
     * 4. java 中的常量 约定俗称 的要全部大写,多个单词用 _ 线 分开
     * 只要是 static final 修饰
     *
     */
    public static final int AGE = 100; // ✅
    public static final int MY_AGE = 100;// ✅
    /***
     * jdk 中的 Math.PI  Math.E  都是常量
     */

}


public class AppTest {
    /***
     * PS : 基本类型 和 字符串 类型 才能类似宏替换.
     * 如果这种编译的时候 就能确定的常量值 (只要不是方法调用能获取的) , 编译器会优化 直接 替换掉使用的地方,(毕竟找内存地址获取也是开销,不如立即数来的快)
     * 类似 C 语言的 宏替换
     * 这中常量 我们也叫做 编译时 常量. AGE1 AGE0
     */
    public static final int AGE1 = 10;
    public static final int AGE0 = 10 * 10 + 50;
    public static final String NAME = "abc";
    /**PS : 基本类型 和 字符串 类型 才能类似宏替换. 如上👆🏻 */


    /**
     * AGE2 : 给 就不能在编译的时候确定值.需要在程序运行的时候才能知道是什么值.为何说运行的时候,因为函数调用需要开辟栈帧
     */
    public static final int AGE2 = getAge(100);
    static int getAge(int x) {
        int a  = 30;
        int b = 50;
        return a*b+x;
    }
    public static void main(String[] args) {
        /**
         * jdk 中的 Math.PI  Math.E 就是用 static final 修饰的常量.
         */
        System.out.println(Math.PI);
        System.out.println(Math.E);

        System.out.println(AGE1); //直接替换为 10
        System.out.println(AGE1);
        System.out.println(AGE1);
    }
}
