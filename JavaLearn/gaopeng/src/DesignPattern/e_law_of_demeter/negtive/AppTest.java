package DesignPattern.e_law_of_demeter.negtive;

class Computer {
    public void saveData() {
        System.out.println("保存数据");
    }
    public void killProcess() {
        System.out.println("关闭程序");
    }

    public void turnOffScreen() {
        System.out.println("关闭屏幕");
    }

    public void powerOff() {
        System.out.println("断电");
    }
}

class Person {
    /// 一个类 作为另一个 类的字段 就是关联关系.(大雁和翅膀的关系)
    // private Computer computer = new Computer(); // 等价构造代码块.
    private final Computer computer;

    public Person() {
        /// 关联关系,这个类在创建的时候,这个关联的对象也必要要同时初始化.(大雁和翅膀的关系)
        computer = new Computer();
    }
    /**
     * 在这个关机的方法中, 这个Person 对于Computer 的细节就知道的太多了.
     * 对于Person而言,只需要知道,关机按钮在哪里就行, 不需要摘掉如何保存数据,
     * 如何关闭进程,如何断电等等这些细节.
     * 如此一来,代码的复杂度就提升了.万一用户使用不当,就可能造成更大的损失.
     */
    public void shutDownComputer() {
        //computer.powerOff(); //万一这里用户直接来了先断了电 再保存数据 ❌
        // 因为暴露太多的东西.
        // 正常顺序.
        computer.saveData();
        computer.killProcess();
        computer.turnOffScreen();
        computer.powerOff();
    }
}



public class AppTest {
    public static void main(String[] args) {

    }
}
