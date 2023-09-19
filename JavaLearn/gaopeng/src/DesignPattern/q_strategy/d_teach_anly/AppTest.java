package DesignPattern.q_strategy.d_teach_anly;

/**
 * 老师讲解版本：
 */

/**
 飞行策略：
 */
interface FlyStrategy {
    void fly();
}

class Duck {
    /// 更换飞行策略的方法：
    /// 策略模式 不要写在构造器中，后面没法更换。
    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    FlyStrategy flyStrategy;
    public void performFly(){
        /// 策略模式的最核心的一句就是这个使用接口调用，
        /// 外面设置了不同的飞行策略。 这里就会
        flyStrategy.fly();
    }
}

///飞行的策略
class Wing implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("用翅膀飞~~~~");
    }
}

class Plane implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("坐飞机飞✈️");
    }
}

class Rocket implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("绑个🚀🚀🚀 窜天猴 飞！！！！");
    }
}
/// =======================时空分割线=======================

// 下面是用户端扩展的 飞行策略
class KickOff implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("被踢飞了——拜拜了您！");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setFlyStrategy(new Wing());
        duck.performFly();
        duck.performFly();


        ///更换飞行策略
        duck.setFlyStrategy(new Plane());
        duck.performFly();
        duck.performFly();

        ///更换飞行策略
        duck.setFlyStrategy(new Rocket());
        duck.performFly();
        duck.performFly();

        //被踢飞--更换策略
        duck.setFlyStrategy(new KickOff());
        duck.performFly();
    }
}
