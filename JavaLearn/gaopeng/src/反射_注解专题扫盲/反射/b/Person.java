package 反射_注解专题扫盲.反射.b;


import java.util.Date;

public class Person {

    static {
        System.out.println("Person --静态代码块");
    }
    private String  name;
    private int age;
    private static String str = "娃哈哈";

    public Person() {
        System.out.println("Person()");
    }
    protected Person(String name) {
        this.name = name;
        System.out.println("Person(String name) name = " + name);
    }

    Person(int age) {
        this.age = age;
        System.out.println("Person(int age) age = " + age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.format("Person(String name, int age) name = %s , age = %d \n", name,age);
    }

    public void eat() {
        System.out.println(this.name + "吃饭~~~");
    }
    public void eat(String food) {
        System.out.println( this.name + " 吃 " + food);
    }

    public int  add(int a, int b) {
        return a + b;
    }

    public static int times(int a, int b) {
        return  a*b;
    }

    public Date f1(String[] strings, Class[][][][] c, Integer a) {
        return new Date();
    }

    @Override
    public String toString() {
        return "Person的信息:  Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'+ '@' + hashCode();
    }
}