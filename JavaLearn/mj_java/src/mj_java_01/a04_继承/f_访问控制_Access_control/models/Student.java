package mj_java_01.a04_继承.f_访问控制_Access_control.models;

public class Student extends Person {
    public void showInfo() {
        //子类可以访问 protected 的属性
        System.out.println(age);
    }
}
