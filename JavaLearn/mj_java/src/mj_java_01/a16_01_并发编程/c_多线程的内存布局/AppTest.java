package mj_java_01.a16_01_并发编程.c_多线程的内存布局;

public class AppTest {

    public static void main(String[] args) {
        /**
         * PC 寄存器: 每一个线程都有自己的 PC 寄存器
         *      记录:当前执行的指令地址.每个线程都有自己的记录.
         *
         * java虚拟机栈: 每一个线程都有自己的 java 虚拟机栈.(必须自己各自各的栈)
         *      因为每个线程都可以调用方法,方法是要分配栈空间的.
         *
         *  本地方法栈: 每个线程都有自己的本地方法栈. 因为每个线程可以调用C语言方法,
         *  只要是方法调用就要分配栈空间. 所以多个线程不能混用一个栈空间.
         */
    }
}
