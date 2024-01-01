package mj_java_01.a16_01_并发编程.e_sleep_interrupt;

public class AppTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //扰断,干扰.
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
        System.out.println(3);

        /**
         * 在暂停期间,若调用 线程对象的 interrupt 方法中断线程,
         * 就会抛出 java.lang.InterruptedException: sleep interrupted 异常.
         */
        thread.interrupt();

    }
}
