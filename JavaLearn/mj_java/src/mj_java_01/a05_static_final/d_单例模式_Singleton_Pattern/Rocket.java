package mj_java_01.a05_static_final.d_单例模式_Singleton_Pattern;

public class Rocket {

    //私有的静态实例变量: 静态变量程序运行过程中内存只有一份.
    private static Rocket instance = null;//懒汉式 用到时候在创建
    private static Rocket instance1 = new Rocket(); //饿汉式 推荐 ✅

    private Rocket() {

    }

    /**
     * 提供一个公共静态的方法,返回唯一的那个实例
     */
    public static Rocket getInstance() {
        if (instance == null) { // 懒汉式 有线程安全问题 后面讲多线程会回头补充
            instance = new Rocket();
        }
        return instance;
    }

    public static Rocket getInstance1() {
        return instance1; //饿汉式 返回的
    }


}
