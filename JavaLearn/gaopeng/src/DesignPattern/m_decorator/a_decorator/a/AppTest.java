package DesignPattern.m_decorator.a_decorator.a;

/**
 * 业务场景:星巴克卖咖啡,因为所有咖啡一开始,只有图里的 4中 咖啡 : Decaf Espresso DarkRoast HouseBlend
 * 因为所有咖啡都有共性: 所以开发人员把他们共性上提到一个父类中 Beverage (除水以外的饮料)
 */
abstract class Beverage {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 关于咖啡的描述.
     */
    private String description;
    Beverage(String description) {
        this.description = description;
    }

    /**
     * 具体花费多少 现在不知道,交给子类去处理 为具体的价格.
     */
    public abstract double cost();

}

/**
 * 无咖啡因 咖啡.
 */
class Decaf extends Beverage {

    Decaf() {
        super("Decaf无咖啡因咖啡");
    }

    @Override
    public double cost() {
        return 1.0;
    }
}

/**
 * 浓缩咖啡
 */
class Espresso extends Beverage {

    Espresso() {
        super("浓缩(Espresso)咖啡");
    }
    @Override
    public double cost() {
        return 2.0;
    }
}

/**
 * 焦炒咖啡
 */
class DarkRoast extends  Beverage {
    DarkRoast() {
        super("焦炒(DarkRoast)咖啡");
    }
    @Override
    public double cost() {
        return 1.5;
    }
}

/**
 * 混合咖啡
 */
class HouseBlend extends  Beverage {
    HouseBlend() {
        super("混合(HouseBlend)咖啡");
    }
    @Override
    public double cost() {
        return 3.0;
    }
}

public class AppTest {
    public static void main(String[] args) {
        Beverage beverage = new Decaf();
        Beverage beverage1 = new Espresso();
        Beverage beverage2 = new DarkRoast();
        Beverage beverage3 = new HouseBlend();

        System.out.println(beverage.getDescription() + " : " + beverage.cost());
        System.out.println(beverage1.getDescription() + " : " + beverage1.cost());
        System.out.println(beverage2.getDescription() + " : " + beverage2.cost());
        System.out.println(beverage3.getDescription() + " : " + beverage3.cost());
    }
}
/**
 * 目前 这段代码看起来没有问题.
 *
 * 问题是:变化来了:
 * 老板为了提高自身竞争力,相出一个新业务:调料,也就是可以给咖啡中放调料:牛奶, 豆浆, 摩卡, 泡沫(只是为了好看)
 * 如何设计,以应对变化呢? 看 b 包.
 */