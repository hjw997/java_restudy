package ThreadTopic.a_fixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1：线程池 的基本使用 固定数量线程池。
 *
 */

public class AppTest1 {
    public static void main(String[] args) {
        /// 创建一个 有2个线程的线程池： newFixedThreadPool ： 新的(创建）的 固定的线程的  线程池
        /// ExecutorService 就是线程池的意思。以后就使用这个线程池中的 3个 线程。
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //execute 执行的意思。execute(参数是Runnable）
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("a");
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("bb");
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("ccc");
                }
            }
        });
        //// d 不能输出，因为线程池 只有3个 没可用线程去执行
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("d-----");
                }
            }
        });




        threadPool.shutdown();///线程池 用完记得要释放资源。
    }
}
