package mj_java_01.a16_01_并发编程.m_可重入锁_ReentrantLock.b_车站卖票_可重入锁;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class AppTest {
    public static void main(String[] args) {

        Station station = new Station();
        //一个车站 开启四个线程开始卖票.
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(station);
            thread.setName("线程-" + i);
            thread.start();
        }

    }

    @Test
    public void test01() {
        new Thread(() -> {
            System.out.println(1);
            // java中 synchronized 默认是可重入锁.
            // 有些编程语言,下面的这种写法是进不去的,因为不是可重入锁.
            synchronized ("1") {
                System.out.println(2);
                synchronized ("1") { //假如这里不是可重入锁,到这就进入等待状态.因为上一句已经获取了锁,到这不可重复就等.
                    System.out.println(3);
                }
            }
            System.out.println(4);
        }).start();

        /**
         * 可重入锁,有些地方也叫 递归锁.
         */

    }

}
class Station implements Runnable {
    //车站的总票数:
    private int tickets = 100;

    private ReentrantLock lock = new ReentrantLock();

    public  boolean  saleTicket() {
//        lock.lock()
//        if (tickets < 1 ) return false;
//        tickets--;
//        System.out.println(Thread.currentThread().getName() + " 卖出一张票, 还剩 " + tickets);
//        return tickets > 0 ; //还有没有票, 票数 > 0 才有票.
//        lock.unlock(); ???

        //如何保证:return 后 锁一定会解开. try-finally
        /**
         * 如果 try 或者 catch 中使用了 return, break ,continue 等提前结束的语句
         * finally 会在 return ,break continue 之前执行.✅✅✅.
         */
        try {
            lock.lock();
            /**
             * lock() 是必须要获取到这把锁,要是发现这把锁被其他线程拥有,那么就等 . 等到拿到锁.
             */
            /**
             boolean flag = lock.tryLock(); 尝试去拿锁,成功返回true, 没拿到 false. 然后就继续往下走.
             解锁搭配:if(flag) lock.unlock(); 只有拥有锁才能解锁,否则报错.
             */

            //lock.isLocked();//查看这个锁是否被哪个线程拥有
            if (tickets < 1 ) return false;
            tickets--;
            System.out.println(Thread.currentThread().getName() + " 卖出一张票, 还剩 " + tickets);
            return tickets > 0 ; //还有没有票, 票数 > 0 才有票.
        } finally { //
            lock.unlock();
        }

    }


    /**
     * 线程开启后 执行的任务, 就是卖票.
     */
    @Override
    public void run() {
        while (saleTicket());
        System.out.println("已售罄~~");
    }
}
