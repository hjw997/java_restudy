package DesignPattern.l_builder.c;

/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象, 以及给 该对象的属性赋值.
 *
 * 针对 b 包中的问题,修改代码如下:
 * 针对不同的需求,我们需要创建不同的配置的建造者,来分别生产不同配置的产品.
 *
 *
 */
class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }
}

/**
 * 电脑建造者 ,建造者类, 必须关联电脑产品
 * 下面创建不同的 三个配置的创建者:
 */
class AdvancedComputerBuilder {
   //关联电脑产品:一个类作为另一个类的字段属性.
    private Computer computer = new Computer(); ///起初这个电脑还没有任何配置.

    public Computer build() {
        //在返回之前 由建造者 注入属性
        computer.setCpu("i7 8750HK"); //i7 8750uu 低压的.
        computer.setGpu("rtx2080ti");
        computer.setMemory("32G");
        computer.setHd("500G固态+2T机械");
        return computer;
    }
}

class MiddleComputerBuilder {
    //关联电脑产品:一个类作为另一个类的字段属性.
    private Computer computer = new Computer(); ///起初这个电脑还没有任何配置.

    public Computer build() {
        //在返回之前 由建造者 注入属性
        computer.setCpu("i7 7700hq"); //i7 8750uu 低压的.
        computer.setGpu("gtx1060");
        computer.setMemory("16G");
        computer.setHd("2T机械");
        return computer;
    }
}

class LowConfigComputerBuilder {
    //关联电脑产品:一个类作为另一个类的字段属性.
    private Computer computer = new Computer(); ///起初这个电脑还没有任何配置.

    public Computer build() {
        //在返回之前 由建造者 注入属性
        computer.setCpu("i7 7500u"); //i7 8750uu 低压的.
        computer.setGpu("gtx940mx");
        computer.setMemory("8G");
        computer.setHd("1T机械");
        return computer;
    }
}
// ======================时空线==========================

public class AppTest {
    public static void main(String[] args) {

        //玩游戏
        AdvancedComputerBuilder cb = new AdvancedComputerBuilder();
        Computer computerGame = cb.build();
        System.out.println(computerGame);

        //开发
        MiddleComputerBuilder middleCb  = new MiddleComputerBuilder();
        Computer computerDev = middleCb.build();
        System.out.println(computerDev);

        //办公娱乐
        LowConfigComputerBuilder lowCb  = new LowConfigComputerBuilder();
        Computer computerLowConfig = lowCb.build();
        System.out.println(computerLowConfig);

        /**

         */
    }
}
/**
 *
 * 这仍然不是建造者模式:
 * 优点:
 *   1.可以更具客户端的不同需求使用不同的建造者来生产产品.
 *
 *  缺点:
 *    1.我们发现多个不同的建造者的代码在重复. 既然代码中 有了 重复的代码 就有了 "坏味道"
 *    2.建造的过程不稳定,如果在某个建造者创建产品的过程中.漏了一步,比如忘了装显卡, 编译器也不会报错.
 *
 *    相当于,KFC 的某一家分店,制作汉堡的流程突然少了某一个步骤,出来的汉堡味道就变味了! 因为没有标准.
 *
 *    过程不稳定就会出现不稳定.
 *
 */
