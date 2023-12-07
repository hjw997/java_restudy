package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.e_方法引用_简化lambda.f_引用当前类中定义的实例方法;


interface TestAble {
    void test(int v);
}
class Person {
    public void setAge(int age) {
        System.out.println("set-Age - " + age);
    }
    public void show() {
        TestAble t0 =  new TestAble() {
            @Override
            public void test(int v) {
                setAge(v);
            }
        };
        t0.test(22);

        //lambda 中内容仅仅是方法调用 进一步简化方法引用.
        TestAble t1 = v -> setAge(v);
        t1.test(33);

        //引用当前类中定义的 实例方法: this.实例方法.
        TestAble t2 = this::setAge;
        t2.test(33);

    }
}
public class AppTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();
    }
}
