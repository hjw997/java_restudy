package mj_java_01.a16_01_并发编程.g_线程安全01_问题.b_线程安全问题_卖票案例;

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
     * 该程序 有线程安全问题.售票 数据错乱.
     */
}
class Station implements Runnable {
    //车站的总票数:
    private int tickets = 100;

    /**
     * 卖出一张票.
     * @return
     */
    public boolean saleTicket() {
        if (tickets < 1 ) return false;
        tickets--;
        /**
         * tickets-- ; 细化:
         * ticket = ticket - 1;
         * 汇编层面 :
         *   int oldTickets(寄存器) = tickets;
         *   oldTickets = oldTickets -1;
         *   tickets = oldTickets;
         *   假设 tickets = 2 . 四个线程同时来 到 这个方法,发现 tickets 不小于1  都进来 ticket--
         *   就会造成数据错乱.
         */

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
