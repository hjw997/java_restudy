package mj_java_01.a16_01_并发编程.m_可重入锁_ReentrantLock.a_回顾车站卖票;

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

}
class Station implements Runnable {
    //车站的总票数:
    private int tickets = 100;

    public synchronized boolean  saleTicket() {
        //就是保证了同一时间,只有一个线程能进入这里面的代码
        if (tickets < 1 ) return false;
        tickets--;
        System.out.println(Thread.currentThread().getName() + " 卖出一张票, 还剩 " + tickets);
        return tickets > 0 ; //还有没有票, 票数 > 0 才有票.
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
