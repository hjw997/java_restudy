package mj_java_01.a16_01_并发编程.i_线程安全问题03_同步方法;

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
    /**
     *  该程序对多线程操作的资源加了锁,
     *  加锁的这种技术 叫做 线程同步技术
     *  此案例: 同步方法.
     *  PS 加锁不到必要不要加,除非多个线程对同一个资源有写操作,才考虑加锁,如果是读,也不用加.
     *  不要步入误区,看到多线程访问同一资源就加锁.

     */
}
class Station implements Runnable {
    //车站的总票数:
    private int tickets = 100;

    /**
     * 卖出一张票.
     * @return true 还有票. false 没有票.
     * 返回值 前面加 synchronized 就是 同步方法.
     * 方法: 构造方法, 实例方法 ,静态方法.
     * 注意点: synchronized 不能修饰构造方法.
     */
    public synchronized boolean  saleTicket() {
        //就是保证了同一时间,只有一个线程能进入这里面的代码
        if (tickets < 1 ) return false;
        tickets--;
        System.out.println(Thread.currentThread().getName() + " 卖出一张票, 还剩 " + tickets);
        return tickets > 0 ; //还有没有票, 票数 > 0 才有票.
    }

    /**
     * 同步方法的本质:
     * 1.实例方法的本质 :  synchronized (this) {}
     */
    public  boolean  saleTicket1() {
        synchronized (this) {
            if (tickets < 1 ) return false;
            tickets--;
            System.out.println(Thread.currentThread().getName() + " 卖出一张票, 还剩 " + tickets);
            return tickets > 0 ; //还有没有票, 票数 > 0 才有票.
        }
    }

    /**
     * 2.静态方法: synchronized (类对象) {}
     * 每一个类都有一个类对象,每个类的类对象只有一份内存.
     */
    public static synchronized void test01() {
        System.out.println("静态同步方法");
    }
    public static void test02() {
        /**
         *  synchronized (类对象) {
         *      System.out.println("静态同步方法");
         *  }
         */
        synchronized (Station.class) {
            System.out.println("静态同步方法");
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
