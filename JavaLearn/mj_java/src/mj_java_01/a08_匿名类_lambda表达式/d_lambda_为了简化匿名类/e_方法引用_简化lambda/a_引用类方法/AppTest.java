package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.e_方法引用_简化lambda.a_引用类方法;

import org.junit.Test;

/**
 * lambda 是对 匿名类的一个简化
 * 方法应用 : 是对 lambda表达式 的一个简化.
 * 什么是方法引用:
 * 如果 lambda 中的内容仅仅是调用某个方法,可以使用方法引用 (Method Reference) 来简化
 */
@FunctionalInterface
interface Testable1 { //函数式接口
    int test(int v1, int v2);
}

public class AppTest {
    /**
     * 01.方法引用: 类方法:
     */
    @Test
    public void test01_Max() {

        //假设 求 v1 v2 的最大值
        Testable1 t1 = (v1, v2) -> {
            return Math.max(v1, v2);
        };
        System.out.println( t1.test(10, 29));;
        //简化 只有一条语句: 省略 return 和 {} 都不要.
        Testable1 t2 = (v1, v2) -> Math.max(v1, v2);

        //✅ 使用方法引用简化:lambda 中的内容仅仅是调用某个方法
        Testable1 t3 = Math::max;
        System.out.println(t3.test(30, 40));

    }
}
