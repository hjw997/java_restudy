package DesignPattern.e_law_of_demeter.positive;

class Computer {
    /// 操作的方法不对外暴露了.具体细节外界不需要知道.
    private void saveData() {
        System.out.println("保存数据");
    }
    private void killProcess() {
        System.out.println("关闭程序");
    }

    private void turnOffScreen() {
        System.out.println("关闭屏幕");
    }

    private void powerOff() {
        System.out.println("断电");
    }

    /// 只对外开放一个方法给外界用
    public void shutDown() {
        //正常顺序.
        this.saveData();
        this.killProcess();
        this.turnOffScreen();
        this.powerOff();
    }
}

class Person {

    private final Computer computer ;

    public Person() {
        /// 关联关系,这个类在创建的时候,这个关联的对象也必要要同时初始化.(大雁和翅膀的关系)
        computer = new Computer();
    }
    /**
      此时关机 就变得简单了. 用户只知道 有关机这个功能.
      其他的交给 电脑 自己去处理逻辑.
     */
    public void shutDownComputer() {
        computer.shutDown();
    }
}



public class AppTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.shutDownComputer();
    }
}
