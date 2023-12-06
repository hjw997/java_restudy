package mj_java_01.a08_匿名类_lambda表达式.d_lambda.b_lambda的简化推导;

import mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util.Files;
import mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util.Times;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 主要演示 lambda 简化推导的过程.
 */
public class AppTest {

    @Test
    public void testLambda01() {
        /**
         * lambda 的标准格式:
         * (参数列表) -> {
         *   //方法体
         * }
         * 这么看就是个函数.这个函数 其实就是 函数式接口中的 唯一的函数. 所以 lambda 表达的就是 函数式接口中的 函数实现体.
         */
        Times.test(new Times.Block() {
            @Override
            public void execute() {
                //测试代码
                int sum = 0;
                for (int i = 0; i <= 100_000_000; i++) {
                    sum += i;
                }
                System.out.println("sum = " + sum);
            }
        });


        Files.getAllFileNames("/Users/xxx/Desktop/io_test", new Files.Filter() {
            @Override
            public boolean accept(String fileName) {
                //只接受 过滤 含有 类 的 文件.
                return fileName.contains("类");
            }
        });
        //lambda 简化;

        Files.getAllFileNames("/Users/xxx/Desktop/io_test", (String fileName) -> {
            //只接受 过滤 含有 类 的 文件.
            return fileName.contains("类");
        });
        // 参数类型是可以推导出的 再简化: (String fileName)
        Files.getAllFileNames("/Users/xxx/Desktop/io_test", (fileName)  -> {
            //只接受 过滤 含有 类 的 文件.
            return fileName.contains("类");
        });
        // 如果只有一个参数() 可以省略
        Files.getAllFileNames("/Users/xxx/Desktop/io_test", fileName -> {
            //只接受 过滤 含有 类 的 文件.
            return fileName.contains("类");
        });
        //但是如果 没有参数时() 小括号 不能省略:
        Times.test(() -> { //没有参数 () 也不能省略
            //测试代码
            int sum = 0;
            for (int i = 0; i <= 100_000_000; i++) {
                sum += i;
            }
            System.out.println("sum = " + sum);
        });

        // 如果有多个参数那么() 不可省略,参数类型因为可以推导可以省略.
        Integer[] array = {33, 22, 11, 77, 66, 99};
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 ;
            }
        });
        //简化为 lambda 表达式:
        Arrays.sort(array, (o1, o2) ->{ //多个参数时,参数列表的小括号不可以省略.省了会报错.
            return  o1 - o2;
        });
        //如果 lambda 式中只有一条语句的时候,里面的 return 都可以省略
        Arrays.sort(array, (o1, o2) -> o1 - o2);
        Times.test(() -> System.out.println("只有一行代码的简化"));


        /** 接口中如果有两个自己定义的抽象方法的就不是函数式接口,所以无法使用 lambda 表达式简化.*/

    }
}
