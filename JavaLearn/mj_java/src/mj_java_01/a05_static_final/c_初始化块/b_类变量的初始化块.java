package mj_java_01.a05_static_final.c_初始化块;

class Student {
    public static int count;
    /**
     * 如何手动给类变量提供初始值呢?
     * 1.声明中
     *   public static int count = 0;
     * 2.在静态初始化块中(也叫静态代码块).
     * 静态初始化块 什么时候执行?
     * 当一个类被初始化的时候执行 静态初始化块
     * 那么什么时候一个类被初始化呢?
     * 当一个类 第一次 被主动使用时 ,JVM会对类进行初始化. 也就是说程序运行的时候只要没用到这个类 JVM就不会对这个类进行初始化.
     * 第二次 第三次 就不会执行. 最多执行一次.
     *
     */
    static {
        count = 10 ;
        System.out.println("static");
        /**
         * 静态代码块中 做 的事情是 整个程序中 只想执行一次的事情.
         */
    }
}
public class b_类变量的初始化块 {
    public static void main(String[] args) {
        System.out.println(Student.count);
        System.out.println(Student.count);
    }
}
