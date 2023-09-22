package ThreadTopic.b_cachedThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Task implements Runnable {
    private static int seed = 1; //静态代码块 只会在类的加载的时候执行一次。
    private int id = seed++; //先用后加
    /// 以上实现 id 自增长。new 一个对象 id 增长一次

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 开始执行~" + " 任务 " +  id );
        sleep(); // 有try-catch 看起来太乱，抽取一个方法。阅读性高
        System.out.println(name + " 执行完   " + " 任务 " + id);
    }

    private  void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class AppTest {
    public static void main(String[] args) {
        /// 缓存线程池的特点是 ： 来多少任务。就创建多少个线程，用完的线程会放到缓存线程池中。
        /// 等待一定时间（60秒） 后没有可执行的任务就会销毁
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            cachedThreadPool.execute(new Task());
        }

        //释放资源。
        cachedThreadPool.shutdown();
    }
}
