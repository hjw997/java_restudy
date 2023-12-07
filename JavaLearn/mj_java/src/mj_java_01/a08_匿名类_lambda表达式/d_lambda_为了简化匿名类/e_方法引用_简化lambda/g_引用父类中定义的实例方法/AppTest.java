package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.e_方法引用_简化lambda.g_引用父类中定义的实例方法;


interface TestAble {
    void test(int v);
}
class Person {
    public void setAge(int age) {
        System.out.println(" Person - set-Age - " + age);
    }
}

class Student extends Person {
    @Override
    public void setAge(int age) {
        System.out.println("Student set -age ");
    }

    public void show() {
        TestAble t0 =  new TestAble() {
            @Override
            public void test(int v) {
                // 因为这个 匿名类 没有父类 所以 使用 Student.super.
                Student.super.setAge(33);
            }
        };
        t0.test(22);

        //lambda 中内容仅仅是方法调用 进一步简化方法引用.
        TestAble t1 = v -> super.setAge(v);
        t1.test(33);

        //引用父类 类中定义的 实例方法: super.实例方法.
        TestAble t2 = super::setAge;
        t2.test(33);

    }
}
public class AppTest {
    public static void main(String[] args) {
       Student student = new Student();
       student.show();
    }
}
/**
 * 思考:
 * 匿名类的 父类是谁? 有父类吗 ?
 */
