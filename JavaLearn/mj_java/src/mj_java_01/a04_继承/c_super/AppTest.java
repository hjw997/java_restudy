package mj_java_01.a04_继承.c_super;



class Person {
    public int age;
    public Person(int age) { /**一旦自己写了构造方法,系统就不会再自动生成无参的构造, 如果需要可以自己手动补上无参构造. */
        this.age = age;
    }
}
class Student extends Person {
    public int no;
    public Student(int no) {
        /**
         * 注意:子类的构造方法会默认去调用 父类的无参构造方法super(),发现父类没有无参构造方法会报错:
         * ❌: There is no default constructor available in 'mj_java_01.a04_继承.c_super.Person'
         */
        // this.no = no; 报错: ❌ Call to 'super()' must be first statement in constructor body
        super(0); /**调用了父类的有参构造方法.自己的构造方法第一行一定要先调用父类的构造方法,才能初始化自己的部分.*/
        this.no = no;
        /**
         * 注意点 : 只有在构造方法中 调用别的构造方法, 调用自己的用this() ,调用父类的 用 super()
         */
    }
}


public class AppTest {
    public static void main(String[] args) {

    }
}
