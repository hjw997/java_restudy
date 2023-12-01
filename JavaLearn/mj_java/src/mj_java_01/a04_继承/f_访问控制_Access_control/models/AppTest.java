package mj_java_01.a04_继承.f_访问控制_Access_control.models;

public class AppTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.age = 20; //自己包中可以访问 protect 的属性
        person.name = "原始人";
    }
}
