package ThreadTopic.c_singleThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private static int seed = 1;
    private int id = seed++;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 开始执行😄 " + " 任务 " +  id );
        sleep(); //
        /// 子线程 如果抛异常就会结束生命周期。 在此处故意抛出一个 异常。线程池 会另找新欢 继续执行后续任务。
        if (id == 5) {
            System.out.println(8/0);
        }
        System.out.println(name + " 执行完 👌🏻 " + " 任务 " + id );

    }

    private  void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/***
 * 单一线程池 ： 顾名思义就是线程池 只有一个线程。
 */

public class AppTest {
    public static void main(String[] args) {
        /// 单一线程池 的特点： 如果线程因为异常终止了，  线程池 会另找新欢 继续执行后续任务。
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            singleThreadExecutor.execute(task);
        }
    }
}
