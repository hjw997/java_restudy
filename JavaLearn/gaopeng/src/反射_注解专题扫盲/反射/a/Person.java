package 反射_注解专题扫盲.反射.a;

public class Person {

    static {
        System.out.println("Person --静态代码块");
    }
    private String  name;
    private int age;

    public void eat() {
        System.out.println("吃饭~~~");
    }
}
