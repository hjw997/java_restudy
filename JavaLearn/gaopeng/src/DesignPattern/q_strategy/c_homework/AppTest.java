package DesignPattern.q_strategy.c_homework;


interface Flyable {
    void fly();
}

class Duck {
    public void setFlyTool(Flyable flyTool) {
        this.flyTool = flyTool;
    }

    private Flyable flyTool;

    public void fly(){
        flyTool.fly();
    }
}

class Wings implements Flyable {

    @Override
    public void fly() {
        System.out.println("使用翅膀飞！！！");
    }

}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("飞机飞✈️✈️！");
    }
}


public class AppTest {
    public static void main(String[] args) {
       Duck duck = new Duck();
        duck.setFlyTool(new Wings());
        duck.fly();
        duck.fly();

       /// 更换策略
        duck.setFlyTool(new Plane());
        duck.fly();
        duck.fly();
    }
}
