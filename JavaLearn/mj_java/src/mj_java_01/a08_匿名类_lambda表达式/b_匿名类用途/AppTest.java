package mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途;

import mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util.Files;
import mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util.NetWorks;
import mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util.Times;

import java.util.ArrayList;
import java.util.Arrays;

public class AppTest {
    public static void main(String[] args) {
         //1.计算代码执行时间
         testCodeTime();

         //2.网络请求-回调
         testNetworkRequest();
         
         //3.过滤器
        ArrayList<String> filteredFiles = Files.getAllFileNames("/Users/xxx/Desktop/io_test", new Files.Filter() {
            @Override
            public boolean accept(String fileName) {
                //只接受 过滤 含有 类 的 文件.
                return fileName.contains("类");
            }
        });
        System.out.println(Arrays.toString(filteredFiles.toArray()));

    }

    /**
     * 匿名类用法:
     * 1.计算一段代码执行时间
     */
    public static void testCodeTime() {
        //1.匿名类用法 -计算一段代码执行时间
        /**
         * ✅ 将 一段 外面的代码 传递到 里面去执行: 可以使用匿名类.
         */
        Times.test(new Times.Block() {
            @Override
            public void execute() {
                int sum = 0;
                for (int i = 0; i <= 100_000_000; i++) {
                    sum += i;
                }
                System.out.println("sum = " + sum);
            }
        });
    }

    public static void testNetworkRequest() {
        NetWorks.get("https://www.xxx.com?name=mj&age=18", new NetWorks.Block() {
            @Override
            public void success(Object json) {
                System.out.println("请求成功👌");
            }
            @Override
            public void failure(Throwable throwable) {
                System.out.println("请求失败❌ msg = " + throwable.getMessage());
            }
        });

    }
}
