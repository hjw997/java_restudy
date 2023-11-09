package DesignPattern.l_builder.d;


/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象, 以及给 该对象的属性赋值.
 *
 * 针对 c 包中的问题,修改代码如下:
 * 创建一个建造者接口,把制作产品的具体步骤,稳定下来.
 * 我们让建造者类,去实现建造者接口,接口中的方法步骤,类就必须去实现, 少实现一个抽象方法就会报错.
 * 有接口在 过程就稳定了下来了.
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


public class AppTest {
    public static void main(String[] args) {

        //玩游戏
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        acb.setCpu();
        acb.setGpu();
        acb.setMemory();
        acb.setHd();
        Computer computerGame = acb.build();
        System.out.println(computerGame);

        //开发
        MiddleComputerBuilder middleCb  = new MiddleComputerBuilder();
        middleCb.setCpu();
        middleCb.setGpu();
        middleCb.setMemory();
        middleCb.setHd();
        Computer computerDev = middleCb.build();
        System.out.println(computerDev);

        //办公娱乐
        LowConfigComputerBuilder lowCb  = new LowConfigComputerBuilder();
        /**指挥装机boy一步步的做啥: 缺点一步错,其他可能就装不上.*/
        lowCb.setCpu();
        lowCb.setGpu();
        lowCb.setMemory();
        lowCb.setHd();
        Computer computerLowConfig = lowCb.build();
        System.out.println(computerLowConfig);

        /**

         */
    }
}
/**
 *
 * 这仍然不是建造者模式:
   这还不是建造者模式

   >优点
    建造者类中的建造过程 (注意不是流程) 是稳定的,不会漏了某一步,这样客户端想扩展 新的建造者时,也不会漏掉某一个步骤.

   缺点:
      1.代码任然有重复(那一堆的 setCpu() setGpu() .... 一堆方法.
      2.客户端又变成客户端自己配置电脑,又违反了 迪米特法则
        这样 客户端指挥 建造者去 一步一步做什么的步骤(流程). 如果有一步骤先后顺序不对. 就会造成 创建的对象有问题.
 *
 */
