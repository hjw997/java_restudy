package DesignPattern.m_decorator.a_decorator.d;

/**
 * 业务场景:星巴克卖咖啡,因为所有咖啡一开始,只有图里的 4中 咖啡 : Decaf Espresso DarkRoast HouseBlend
 * 因为所有咖啡都有共性: 所以开发人员把他们共性上提到一个父类中 Beverage (除水以外的饮料)
 *
 * 针对 c 包中的问题(违法开闭原则), 我们使用 "装饰器模式"来解救我们!
 *
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
        super("Decaf无咖啡因咖啡(1.0) ");
    }

    @Override
    public double cost() {
        //咖啡本身价格
        return 1.0 ;
    }
}

/**
 * 浓缩咖啡
 */
class Espresso extends Beverage {

    Espresso() {
        super("浓缩(Espresso)咖啡(2.0) ");
    }
    @Override
    public double cost() {
        //本身价钱
        return 2.0 ;
    }
}

/**
 * 焦炒咖啡
 */
class DarkRoast extends  Beverage {
    DarkRoast() {
        super("焦炒(DarkRoast)咖啡(1.5) ");
    }
    @Override
    public double cost() {
        //本身价钱
        return 1.5 ;
    }
}

/**
 * 混合咖啡
 */
class HouseBlend extends  Beverage {
    HouseBlend() {
        super("混合(HouseBlend)咖啡(3.0) ");
    }
    @Override
    public double cost() {
        //本身价钱
        return 3.0;
    }
}

/**
 * 1. 新增一个 调料类 condiment 抽象类
 * A condiment is a substance such as salt, pepper,
 * or mustard/ˈmʌs.təd/ (芥末) that you add to food when you eat it in order to improve the flavor/ˈfleɪ.vər/ .
 *
 * 2. 判断两个类之间能不能有继承关系,
 * 主要看两个类之间有没有" is a " 关系.
 *  并且还要符合 里氏替换原则. 父类指针指向子类对象.
 *  以上只是原则,并非语法强制的. 也就是说特定情况下可以违反这个规则. 比如在装饰器模式中就是这样.
 *  尽管 调料不是饮料. 但是为了制作出 装饰器模式,我们让调料去继承饮料.
 *
 *  PS: 装饰器类 : 一边继承 一边关联
 */
abstract class Condiment extends Beverage {

    // 不但 继承饮料 还要 关联饮料(被装饰的对象).
    // 关联就是把一个类的对象,当做另一个类的字段.
    protected final Beverage beverage;
    Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "调料:";
    }
}

class Milk extends Condiment {
    Milk(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        //饮料的价格 + 牛奶自身价格
        return beverage.cost() + 1.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "牛奶(1.0) ";
    }
}

class Soy extends Condiment {
    Soy(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        //饮料的价格 + 牛奶自身价格
        return beverage.cost() + 2.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "豆浆(2.0) ";
    }
}
class Mocha extends Condiment {
    Mocha(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        //饮料的价格 + 牛奶自身价格
        return beverage.cost() + 2.5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "摩卡(2.5) ";
    }
}

class Bubble extends Condiment {
    Bubble(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        //饮料的价格 + 牛奶自身价格
        return beverage.cost() + 1.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "打泡沫(1.0) ";
    }
}



//========================时空线================================
/**
 * 用户自己 新增 饮料 茶:
 */

class Tea extends Beverage {

    Tea() {
        super(" 茶(2.0) ");
    }

    @Override
    public double cost() { //茶的价钱
        //自身价格
        return 2.0 ;
    }
}

/**
 * 新增调料 枸杞: GouQi
 */
class GouQi extends Condiment {

    GouQi(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        //饮料价钱 + 自身价格1元
        return beverage.cost() + 1.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 枸杞(1.0)";
    }
}

public class AppTest {
    public static void main(String[] args) {
        //Beverage b = new Decaf();

        Beverage b = new Tea(); //比如新拓展一个饮料
        //饮料里加牛奶
        Beverage b1 = new Milk(b);
        //再加摩卡
        Beverage b2 = new Mocha(b1);
        //加豆浆
        Beverage b3 = new Soy(b2);
        //加枸杞
        Beverage b4 = new GouQi(b3);

        //System.out.println(b3.getDescription() + " : " + b3.cost());
        System.out.println(b4.getDescription() + " : " + b4.cost());

    }
}

/**
 优点:
 现在比如双份 豆浆 双份牛奶 没法用一个bool去处理.现在需要多少就套多少份.
 加一个新的饮料,不会违反开闭原则. 如加个茶.
 加一个新的调料,也不会违反开闭原则.比如枸杞 GouQi 调料.

 缺点:
 1.增加很多小类,这些小类逻辑将不会非常清晰,不够直观,容易令人迷惑(IO流的时候各种流)

 */