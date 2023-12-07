package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.e_方法引用_简化lambda.d_引用构造方法;

@FunctionalInterface
interface TestAble {
    Object test(int v);
}
class Person {
    public Person(int age) {
        System.out.println("Person - " + age);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + hashCode();
    }
}
public class AppTest {
    public static void main(String[] args) {
       //最开始 是个匿名类 对象:
        TestAble t0 = new TestAble() {
            @Override
            public Object test(int v) {
                //这里返回一个 创建的Person 对象.
                return new Person(v);
            }
        };
        t0.test(10);

        //replace with lambda :
        TestAble t0t0 = v -> {
            //这里返回一个 创建的Person 对象.
            return new Person(v);
        };
        t0t0.test(10);

        //再简化
        TestAble t0t00 = v -> new Person(v);
        t0t00.test(10);

        // 匿名类又可以 使用 lambda 简化:
        // 发现 lambda 中的内容仅仅是调用某个方法 , 这里是只是调用了构造方法.
        TestAble t1 = v -> new Person(v);
        Object obj1 = t1.test(10);
        System.out.println(obj1);

        //✅ 引用构造方法: 类名::new
        TestAble t2 = Person::new;
        Object obj2 = t1.test(20);
        System.out.println(obj2);


    }
}
