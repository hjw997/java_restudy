package mj_java_01.a16_01_并发编程.b_默认线程_主线程_开启线程;

public class AppTest {
    public static void main(String[] args) {
        /**
         * main方法所在的线程-默认线程 也叫主线程
         */
        System.out.println(Thread.currentThread()); //Thread-toString()
        /**
         * Thread[main,5,main]
         * 线程名称, 优先级, 线程组
         */

        /**
         * 只有线程的start()才正真的分配线程所需的资源,开启线程.
         * 否则直接 thread.run() 就相当于 调用 方法. 如果在main 就是 主线程中.
         */


    }
}
