package DesignPattern.l_builder.e;


/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象, 以及给 该对象的属性赋值.
 *
 * 针对 d 包中的问题, 修改代码如下:
 * 建造者模式,终于进化出来了
 * 缺点是 客户端在 指挥. 现在交给服务端来指挥.

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
 * 建造者接口: 让建造的流程标准化. 返回 建造.
 * 让过程稳定化.
 */
interface ComputerBuilder {

    //设置零件:
    void setCpu();
    void setGpu();
    void setMemory();
    void setHd();

    //返回产品
    Computer build();
}

/**
 * 增加一个导演类:导演指挥建造者 怎么制作的流程
 */
class Director {
    public Computer build(ComputerBuilder builder) {
        // 具体的制作 流程让 导演来指挥.
        builder.setCpu();
        builder.setGpu();
        builder.setMemory();
        builder.setHd();
        return builder.build();
    }
}

/**
 * 电脑建造者 ,建造者类, 必须关联电脑产品
 * 下面创建不同的 三个配置的创建者:
 */
class AdvancedComputerBuilder implements ComputerBuilder{
   //关联电脑产品:一个类作为另一个类的字段属性.
    private Computer computer = new Computer(); ///起初这个电脑还没有任何配置.

    @Override
    public void setCpu() {
        //在返回之前 由建造者 注入属性
        computer.setCpu("i7 8750HK"); //i7 8750uu 低压的.
    }
    @Override
    public void setGpu() {
        computer.setGpu("rtx2080ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("32G");
    }

    @Override
    public void setHd() {
        computer.setHd("500G固态+2T机械");
    }

    @Override
    public Computer build() {
        return computer;
    }
}

class MiddleComputerBuilder implements ComputerBuilder {
    //关联电脑产品:一个类作为另一个类的字段属性.
    private Computer computer = new Computer(); ///起初这个电脑还没有任何配置.

    @Override
    public void setCpu() {
        //在返回之前 由建造者 注入属性
        computer.setCpu("i7 7700hq"); //i7 8750uu 低压的.
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx1060");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void setHd() {
        computer.setHd("2T机械");
    }

    public Computer build() {
        return computer;
    }
}

class LowConfigComputerBuilder implements ComputerBuilder {
    //关联电脑产品:一个类作为另一个类的字段属性.
    private Computer computer = new Computer(); ///起初这个电脑还没有任何配置.

    @Override
    public void setCpu() {
        //在返回之前 由建造者 注入属性
        computer.setCpu("i7 7500u"); //i7 8750uu 低压的.
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx940mx");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8G");
    }

    @Override
    public void setHd() {
        computer.setHd("1T机械");
    }

    public Computer build() {
        return computer;
    }
}
// ======================时空线==========================

/**
 * 客户端扩展一个中高配:
 */
class MediumHighComputer implements ComputerBuilder {
    /** 建造者必须与产品 发生关联关系. 你有这个产品我才能建造呀. */
    Computer computer = new Computer();
    @Override
    public void setCpu() {
        computer.setCpu("i5 8500hq");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx1070");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void setHd() {
        computer.setHd("250G固态 + 1T机械");
    }

    @Override
    public Computer build() {
        //返回产品:
        return computer; //依赖 电脑
    }
}

public class AppTest {
    public static void main(String[] args) {

        //创建一个导演对象:
        Director director = new Director();

        //玩游戏
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        // 告诉导演(老板) 来个高配的.
        Computer computerGame = director.build(acb);
        System.out.println(computerGame);

        //开发
        MiddleComputerBuilder middleCb  = new MiddleComputerBuilder();
        // 告诉导演(老板) 来个中配的.
        Computer computerDev = director.build(middleCb);
        System.out.println(computerDev);

        //办公娱乐
        LowConfigComputerBuilder lowCb  = new LowConfigComputerBuilder();
        // 告诉导演(老板) 来个低配的.
        Computer computerLowConfig =  director.build(lowCb);
        System.out.println(computerLowConfig);


        /// 客户端扩展:中高配
        MediumHighComputer mc = new MediumHighComputer();
        Computer mediumComputer = director.build(mc);
        System.out.println(mediumComputer);

    }
}
/**

这就是建造者模式:
 优点:
 1.创建对象的过程是稳定的. 因为有ComputerBuilder 接口来稳定过程
 2.创建对象的过程只写了一次,没有重复代码.(指挥者完成稳定流程)

 3.当需要扩展生产不同配置的电脑的时候,只需要扩展一个 对应的建造者. 不用修改之前的代码.这符合了开闭原则.

 建造者 与 工厂模式的区别:
 工厂模式 只需要一个简单的new , 创建出这个产品即可.
 建造者模式 更注重 在new出产品之后的为产品属性赋值的过程!!!.

 */
