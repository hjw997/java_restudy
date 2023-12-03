package mj_java_01.a05_static_final.d_单例模式_Singleton_Pattern;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 想要一个火箭的 单例类:
         * 1.首先不能多次创建:禁止外面能构造方法创建
         */
//        Rocket rocket1 = new Rocket();
//        Rocket rocket2 = new Rocket();

        //以后就可以通过 这个方法获取单例对象:
        Rocket rocket1 = Rocket.getInstance();
        Rocket rocket2 = Rocket.getInstance();


        //java 中的 == 比较的是 变量中存储的值.引用就是地址值.
        System.out.println(rocket1 == rocket2);
    }
}
