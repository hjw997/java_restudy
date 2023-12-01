package mj_java_01.a04_继承.f_访问控制_Access_control.models;

public class Person {
    protected int age ;

    /**
     * 不加权限默认是 package-private :仅在自己包中可访问使用
     */
    String name;
}
