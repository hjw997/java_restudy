package DesignPattern.l_builder.a;


/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象, 以及给 该对象的属性赋值.
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

// ======================时空线==========================

public class AppTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setCpu("i7 7500");
        computer.setGpu("gt940mx");
        computer.setMemory("16G");
        computer.setHd("1T机械");
        System.out.println(computer);
    }
}
/**
 * 这样做的缺点❌是:
 *  1.客户端开发人员,在实例化好产品对象后, 必须为该对象的每一个属性赋值,这对客户端程序员来说,太麻烦了.
 *  2.违反了迪米特法则(最少知道原则)
 *  我们希望客户端拿到产品,只是直接那个电脑用, 而不是 具体自己去一步一步怎么设置.
 *  相当于去买电脑,商家把零件全给你, 你自己组装电脑.
 *
 *
 *  建造者模式与工厂模式区别:
 *  工厂模式: 都是实例化出一个类的对象即可.(直接拿到一个对象就可以用)
 *  建造者模式:实在实例化出类的对象后,还要给改对象的属性赋值.(更关注过程)
 *
 *
 */
