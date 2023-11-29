package mj_java_01.a02_基础语法_part02.f_栈帧_Stack_Frame;

public class a_栈帧_Stack_frame {
    public static void main(String[] args) {
        /**
         * 什么是栈帧 : 分配给这个方法的一段栈空间.
         * 栈帧 随着方法的调用而创建, 随着方法的结束而销毁, 栈帧存储了方法的局部变量信息.
         */
        test1(10); //test11 方法内部是空执行完后 分配给 test01的栈空间被销毁

        test2(20);//test2 开始执行,分配test2的栈帧,内部又调用test3 , 分配栈帧 test3
    }

    public static void test1(int v) {
        //
    }

    public static void test2(int v) {
        test3(30);
    }

    public static void test3(int v) {

    }
}
