package mj_java_01.a04_继承.d_构造方法的细节;



class Person {
    public Person() {
        System.out.println("Person()");
    }
}
class Student extends Person {
    public int no;
    public Student() {
        /** 编译器 自动加了这句 调用父类的无参的构造方法.*/
        // super();
        System.out.println("Student()");

        /** 错误❌: Call to 'this()' must be first statement in constructor body 为何????*/
        // this(0); // 调用自身的构造函数 public Student(int no)
    }

    public Student(int no) {
        /**
         * 子类的构造方法必须先调用父类的构造方法,再执行后面的代码.
         * 如果子类的构造方法没有显示的调用父类的构造方法,编译器会自动调用父类无参的构造方法.
         *    如果父类没有无参构造就会报错 ❌
         */

        /**
         * 编译器 自动加了这句 调用父类的无参的构造方法. 如果父类没有 无参就会报错 ❌
         */
        // super();
        this.no = no;
    }
}

public class AppTest {
    public static void main(String[] args) {
        Student student = new Student();

    }
}
