package mj_java_01.a16_01_并发编程.j_单例模式改进_安全问题;

public class AppTest {
    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                   Rocket rock =   Rocket.getInstance();
                    System.out.println(rock);
                }
            });
            thread.start();
        }


    }
}

class Rocket {
    private static Rocket instance = null;
    private Rocket() {}

    /**
     * 静态方法加锁.
     * 多个线程进来时候,只有一个线程可进入.
     * @return
     */
    public static synchronized Rocket getInstance() {
        if (instance == null) {
            instance = new Rocket();
        }
        return instance;
    }

}
