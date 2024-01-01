package mj_java_01.a16_01_并发编程.l_线程间通信.a_生产者_消费者;

import org.junit.Test;

public class AppTest {

    @Test
    public void test01() {
        /**
         * 若想要在线程A中成功调用
         * obj.wait obj.notify obj.notifyAll
         * 线程A 必须持有 obj的内部锁 .否则抛异常.
         * 如下的代码:就是当前线程没有持有 drop的内部锁,所以调用就抛异常了
         */
        Drop drop = new Drop();
        drop.notify();
        try {
            drop.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        /**
         1.调用 wait , notify 必须是 同一个对象
         2.调用 wait, notify的线程必须拥有 obj 对象的内部锁.
         */

        Drop drop = new Drop();
        Thread thread1 = new Thread(new Consumer(drop));
        thread1.setName("消费者-线程");
        thread1.start();

        Thread thread2 = new Thread(new Producer(drop));
        thread2.setName("生产者-线程");
        thread2.start();

    }

}

/**
 * 消费者
 */
class Consumer implements Runnable{
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String food = null;
        System.out.println("消费者启动-----");
        while (( food = drop.getFood()) != null) {
            sleep(2000); //模拟在吃
            System.out.println("消费者获得食物 : " + food);
        }
        System.out.println("-------消费-结束--------");
    }

    private void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        System.out.println("生产者启动-----");
        String[] foods = {"Apple", "Beef", "Cake", "Cookies","火锅","盖饭"};
        for (int i = 0; i < foods.length; i++) {
            sleep(2000);
            System.out.println("生产完: " + foods[i]);
            drop.addFood(foods[i]);
        }

        //null 表示 生产完了
        drop.addFood(null);
        System.out.println("----------生产完了---------");

    }

    private void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * 投放:AirDrop 传递的东西(数据)
 */
class Drop {
    private String food ;
    /**
     true: 需要消费者线程等待 . 空食物
     false: 需要生产者线程等待. 没有吃完
     */
    private boolean isEmpty = true;

    /**
     * 消费者线程来调用 .
     * @return
     */
    String getFood() {
        synchronized (this) {
            //消费者来获取食物发现是空的.就要进入等待
            while (isEmpty) { //这里也可用if.但是用while是为了防止wait抛出异常.
                System.out.println(Thread.currentThread().getName() + "进入getFood() 等待...");
                try {
                    /**
                     * ✅ 重点理解: 这个wait方法,必须是加锁进入,
                     * 然后调用wait 时候会释放 obj的内部锁,(要不然在getFood中死锁了)
                     * 让当前线程进入WAITING状态 , 然后就线程执行到这就停住等待.
                     * 直到 有 当初谁的锁进入WAITING 状态的对象调用 notify或notifyAll
                     */
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //加入接收到可以获取食物了
            isEmpty = true;
            notifyAll(); //这个是通知生产者,没有食物了.
            return food;
        }
    }

    /**
     * 生产者线程调用来生产
     * @param food
     */

    public void addFood(String food) {
        synchronized (this) {

            //isEmpty = ture :
            while (!isEmpty){ //不是空的,消费者还没吃完,也是用while,避免wait被打断直接就退出了
                try {
                    /**
                       也是拿着锁进来,然后释放锁,让当前线程进入等待状态
                       要不就和上面的 消费者 死锁了. 还是理解 obj.wait的方法.
                     */
                    wait();
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
            isEmpty = false;
            this.food = food; //食物好了
            notifyAll(); //食物好了-告诉消费者,生产好了.

        }
    }
}


/**
 * 如果有多个线程 wait 的情况下, notify 随机唤醒一个等待它的线程,
 * 如果只有一个线程wait情况下,notify 会唤醒 等待它的线程
 *
 * 特别说明:
 * obj.wait : 释放obj的内部锁,当前线程进入 WAITING 或者 TIMED_WAITING 状态.
 * obj.notifyAll :唤醒因为obj.wait进入WAITING 或者 TIMED_WAITING 状态的线程.
 * obj.notify  : 随机唤醒一个因为obj.wait 进入WAITING 或者 TIMED_WAITING 状态的线程
 *
 */