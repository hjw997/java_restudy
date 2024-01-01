package mj_java_01.a16_01_并发编程.n_线程池.mj_Thread_Pool;

import org.junit.Test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 工作线程
         * 普通线程
         */
    }

    @Test
    public void test01() {
        //固定线程池
        //
        // ExecutorService 是 the newly created thread pool
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //  添加任务 线程池会调出一个线程执行任务.
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        //关闭线程池
        pool.shutdown();

        /**
         * 阻塞和waiting 的区别:
         * BLOCKED状态: 阻塞是等待锁锁 (自旋)
         * waiting是等待别的线程来通知它可以启动了. (真真的休眠了)
         */
    }
}
