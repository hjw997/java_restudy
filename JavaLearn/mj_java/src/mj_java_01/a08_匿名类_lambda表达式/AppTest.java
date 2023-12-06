package mj_java_01.a08_匿名类_lambda表达式;

import mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util.Times;

public class AppTest {
    public static void main(String[] args) {
        //1.匿名类用法 -计算一段代码执行时间 Times.Block 的接口 如果不是 public 这里访问不到 ❌
        Times.test(new Times.Block() {
            @Override
            public void execute() {
                int sum = 0;
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }
                System.out.println("sum" + sum);
            }
        });
    }
}
