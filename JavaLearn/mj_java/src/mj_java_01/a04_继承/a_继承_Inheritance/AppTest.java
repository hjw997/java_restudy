package mj_java_01.a04_继承.a_继承_Inheritance;

/**
 * 学习继承的相关知识:
 */
class Person1 extends Object { /**Java中的任何一个类最终继承在 Object 根基类.不写继承关系 编译器自动给加的 */
    private int age;
}
class Person {
    public int age;
}
class Student extends Person {
    public int no;
}
class GoodStudent extends Student {
    public int no; /** java中,子类可以定义跟父类同名的成员变量,(但是不推荐这么做❌) */

    public int salary;
    public void show() {
        System.out.println(no); //就近原则 先在自身中找.
        System.out.println(this.no);
        System.out.println(super.no);
    }
}
public class AppTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.age = 10;

        Student student = new Student();
        student.age = 20;
        student.no = 1;

        GoodStudent goodStudent = new GoodStudent();
        goodStudent.age = 20;
        goodStudent.no = 2; //内存中有两个 no ,但是先找 自己的. 自己没有找父类的.

        goodStudent.salary = 5000;

        goodStudent.show();

    }
}
