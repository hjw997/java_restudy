package mj_java_01.a16_01_并发编程.k_死锁;

public class AppTest {
    //https://www.bilibili.com/video/BV1F44y1r7cv/?p=83&spm_id_from=pageDriver&vd_source=b386945edbef32fc1df7d8a419f8de78
    public static void main(String[] args) {
        Person jack = new Person("Jack");
        Person rose = new Person("Rose");

        new Thread(() -> {
            jack.hello(rose);
        }).start();

        new Thread(() -> {
            rose.hello(jack); //rose的锁 已经在 jack.hello中调用锁住了.
        }).start();

        /**
         * 上面的 程序也是造成了死锁.
         */
    }
}

class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

//    public synchronized void hello(Person p) {
//        System.out.format("[%s] hello to [%s]%n",name,p.name);
//        // 当前对象打个招呼给 p对象. jack 打招呼给 rose.
//        // p 对象对 this 对象微笑.  rose 对 jack 微笑
//        p.smile(this);
//    }

    public  void hello(Person p) {
        synchronized (this) {
            // 第一个线程: jack 打招呼 给rose jack锁住.
            // 第二个线程: rose 打招呼 给 jack ,这里来了需要rose 的锁,但是rose 的锁 已经在之前的 smile中锁住.
            System.out.format("[%s] hello to [%s]%n",name,p.name);
            // 当前对象打个招呼给 p对象. jack 打招呼给 rose.
            // p 对象对 this 对象微笑.  rose 对 jack 微笑
            p.smile(this); //rose微笑
        }

    }

    public  void smile(Person p) {
        synchronized (this) { //rose微笑,rose 这里锁住了.
            System.out.format("[%s] smile to [%s]%n",name,p.name);
        }

    }
//    public synchronized void smile(Person p) {
//        System.out.format("[%s] smile to [%s]%n",name,p.name);
//    }
}