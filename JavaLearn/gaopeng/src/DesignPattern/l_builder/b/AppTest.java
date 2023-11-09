package DesignPattern.l_builder.b;


/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象, 以及给 该对象的属性赋值.
 *
 * 针对 a 包中的问题,修改代码如下:
 * 作者专门创建一个 Computer 建造者类.
 * 这个类专门负责创建建造者类.
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
 */
class ComputerBuilder {
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

// ======================时空线==========================

public class AppTest {
    public static void main(String[] args) {
        //创建一个建造者
        ComputerBuilder cb = new ComputerBuilder();
        //让建造者来一个 电脑. 比之前使用起来方便.
        Computer computer = cb.build();
        System.out.println(computer);

        //玩游戏
        Computer computerGame = cb.build();
        System.out.println(computerGame);

        //开发
        Computer computerDev = cb.build();
        System.out.println(computerDev);

        //办公娱乐
        Computer computerEntertainment = cb.build();
        System.out.println(computerEntertainment);

        /**
         * 封装的太狠,无论客户的需求是什么, 都是采用最高配置.
         * 相当于你去配电脑,无论什么需求,商家都会给你配置最贵的电脑.
         */
    }
}
/**
 * 目前这种写法还不是建造者模式,目前的优点:
 * 1.客户端程序员需要一个产品时候,直接向建造者要 build 即可.
 * 建造者封装了创建电脑对象的 "复杂" 过程.
 *
 * 目前代码的缺点:
 *  是配置直是建造者的build 的方法中写死的. 用户没法选在需要的定制配置.
 *
 *
 */
