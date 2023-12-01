package mj_java_01.a04_继承.g_封装_toString;

public class AppTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(20);

        System.out.println(p); //打印调用 toString方法.
    }
}
