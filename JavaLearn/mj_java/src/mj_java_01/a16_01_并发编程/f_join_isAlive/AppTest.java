package mj_java_01.a16_01_并发编程.f_join_isAlive;

import org.junit.Test;

public class AppTest {
    public static void main(String[] args) {
        //test01();
        test02();
    }


    public static void test01() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);

        try {
            //当前线程 等待 thread 线程执行完毕了在 往下执行
            thread.join();
            //thread.join(1000); 这个是等待多久.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(4);

        // 任务执行完毕 后 终止状态.
        System.out.println(thread.getState());
        // A.isAlive方法 : 查看线程 A 是否还活着.
        boolean alive = thread.isAlive();
        System.out.println(alive); //false


    }

    /** 打印结果:
     * thread1--begin
     * thread2--begin
     * thread1.isAlive:true
     * thread2--waiting...
     * thread1--睡眠结束
     * thread1--end
     * thread2--waiting...end
     * thread1.state = TERMINATED
     * thread1.isAlive = false
     * thread2--end
     */
    public static void test02() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1--begin");

                try {
                    Thread.sleep(3000);
                    System.out.println("thread1--睡眠结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1--end");
            }
        });

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2--begin");
                System.out.println("thread1.isAlive:" + thread1.isAlive());

                try {
                    System.out.println("thread2--waiting... ");
                    //当前线程 等待 thread1 线程指向完毕再 继续往下走.
                    thread1.join();
                    System.out.println("thread2--waiting...end ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1.state = " + thread1.getState());
                System.out.println("thread1.isAlive = " + thread1.isAlive());
                System.out.println("thread2--end");
            }
        });

        thread2.start();
    }

}
