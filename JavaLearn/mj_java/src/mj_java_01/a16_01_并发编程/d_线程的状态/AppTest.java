package mj_java_01.a16_01_并发编程.d_线程的状态;

public class AppTest {
    public static void main(String[] args) {
        Thread.State state = Thread.currentThread().getState();
        System.out.println(state);

        Thread thread = new Thread();
        Thread.State state1 = thread.getState();
        System.out.println(state1);

        /**
         Thread.State : 枚举类 6中状态.
         NEW: 尚未启动
         BLOCKED : 等待锁.

         WAITING
         TIME WAITING

         TERMINATED : 终止.已经执行完毕.

         */
    }
}
