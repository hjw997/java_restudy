package ThreadTopic.d_newScheduledThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *   任务计划线程池 ScheduledExecutorService
 */
public class AppTest {

    public static void main(String[] args) {
        /// 每隔多久 执行 任务。
        /// 核心线程数 1
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("💥💥💥-----");
            }
        }, 3000, 500, TimeUnit.MILLISECONDS); /// 延迟3秒以后，每隔0.5秒 执行上面的任务。
        /// 不能 shutDown ，否则就看不到上面的效果了
        //scheduledThreadPool.shutdown();
    }
}
