package mj_java_01.a16_01_并发编程.h_线程安全问题02_同步语句;

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
     *  线程同步 : 又分为:
     *  同步语句  : synchronized statement
     *
     *  同步方法 :  synchronized Method
     */
}
class Station implements Runnable {
    //车站的总票数:
    private int tickets = 100;

    /**
     * 卖出一张票.
     * @return true 还有票. false 没有票.
     */
    public boolean saleTicket() {

        /**
         同步语句
         加了这个synchronized(this)
         就是保证了同一时间,只有一个线程能进入这里面的代码
         */
        synchronized (this) { // ok ✅ 都是当前对象 Station 同一个对象.
        //synchronized ("123") {  //字符串常量-字符串常量池中的同一个对象 ok ✅
        //synchronized (new Object()) {  //❌,锁不住,每个线程来都new一个对象.
            if (tickets < 1 ) return false;
            tickets--;
            System.out.println(Thread.currentThread().getName() + " 卖出一张票, 还剩 " + tickets);
            return tickets > 0 ; //还有没有票, 票数 > 0 才有票.
        }

        /** synchronized (obj) 原理:
         *  synchronized (obj) obj表示java中的任何对象,
         *  java中的每个对象都有一个与它相关的内部锁(intrinsic  lock),或者叫 监视器锁(monitor lock) (BLOCKED 阻塞状态)
         *  intrinsic: 英: [ɪn'trɪnsɪk] 固有的,内在的.
         *  synchronized (this) { } this就是当前对象.
         *  第一个执行到同步语句的线程,可以获取到 obj 的内部锁,在执行完同步语句中的代码后释放锁.
         *  只要一个线程持有了内部锁.那么其它线程在同一时刻将无法再获取得此锁.
         *  当他们试图获取此锁是,将会进入 BLOCKED 状态.
         *  PS: 多个线程访问同一个 synchronized (obj)  语句时:
         *      obj对象必须是同一个对象,才能起到同步的作用.
         *   思考: synchronized (new Object()) { } 那还能锁住么? 锁不住的. 不是同一个对象,每个线程来都 new 一个 Object对象.
         */

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
