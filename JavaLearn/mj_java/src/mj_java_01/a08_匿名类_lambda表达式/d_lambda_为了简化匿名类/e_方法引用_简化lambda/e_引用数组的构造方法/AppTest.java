package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.e_方法引用_简化lambda.e_引用数组的构造方法;

interface TestAble {
    Object test(int v);
}

public class AppTest {
    public static void main(String[] args) {
        TestAble t0 = new TestAble() {

            @Override
            public Object test(int v) {
                return new int[v];
            }
        };
        t0.test(10);

        //简化 lambda :
        TestAble t1 = v -> new int[v];
        t1.test(20);

        //简化 lambda : 使用 方法引用 : int[]  其实就是一种类型 int[] 表示int数组类型 .
        TestAble t2 = int[]::new;
        t2.test(10);


    }
}
