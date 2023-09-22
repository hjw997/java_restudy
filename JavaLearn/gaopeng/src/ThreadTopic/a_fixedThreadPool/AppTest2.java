package ThreadTopic.a_fixedThreadPool;


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

public class AppTest2 {
    public static void main(String[] args) {
        /// 线程池中的数量 就 3 个 固定数量的线程池。
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Task());
        }
    }
}
