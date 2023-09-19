package DesignPattern.m_decorator.d;

import java.util.ArrayList;

/**
 *
 * 为了解决 C 包中的问题(加调料破坏开闭原则,需要去原来的父类的代码中修改 :计算调料和描述) ,
 * 现在使用 "装饰器模式" 来解救.
 *
 */

//// 所有饮料(调料）类的顶层父类：
abstract  class  Beverage { ///抽象父类
    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return  description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    abstract public double cost(); ///因为我不知道花费多少 交给子类实现
}

/// 无咖啡因咖啡
class Decaf extends Beverage {

    public Decaf() {
        super("无咖啡因咖啡~ ");
    }
    @Override
    public double cost() { ///重写权限不能比父类小. 抛出更多的异常.
        return 1;
    }
}

/// 浓缩咖啡
class Espresso extends Beverage {

    public Espresso() {
        super("浓缩咖啡~ ");
    }
    @Override
    public double cost() { ///重写权限不能比父类小. 抛出更多的异常.
        return 2 ;
    }
}

/// 焦糖咖啡
class DarkRoast extends Beverage {

    public DarkRoast() {
        super("焦糖咖啡~ ");
    }
    @Override
    public double cost() {
        return 1.5 ;
    }
}

/// 黑咖啡
class HouseBlend extends Beverage {

    public HouseBlend() {
        super("混合咖啡~ ");
    }
    @Override
    public double cost() {
        return 3 ;
    }
}

///
/**
 * 判断两个类之间能不能有继承关系,主要看这个两个类之间有没有"is a " 关系, 并且 还要符合里氏替换原则
 * 以上只是原则, 不是语法强制 的. 也就是说, 在特定情况下, 可以违反这个规则.
 * 比如在装饰器模式中:
 * 调料类 继承自 饮料类. 尽管 调理 不是 饮料. 总之不是 is a 关系.
 * 为了制作出装饰器模式,我们也只能让调理去继承饮料类.
 */
/// 抽象的调料类， 以后只要有调料就继承这个类
abstract class Condiment extends Beverage {
    // 让调料类,关联饮料类的一个对象,这个就是被装修的对象。
    protected Beverage beverage;
    public Condiment(Beverage beverage) {
        super(" 调料: ");
        this.beverage = beverage;
    }
}
/// 现在我们创建一个调料比如 milk 继承自调料
class Milk extends Condiment {
   /// 调料的构造器就包装了一个 饮料
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.5 + beverage.cost(); //自身 + 饮料的价格
    }

    @Override
    public String getDescription() {
        /// 饮料名称 + 调料：加牛奶
        return beverage.getDescription() + " 加牛奶 " ;
    }
}

//再来个调料类：
class Mocha extends Condiment {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.8 + beverage.cost(); /// 自身价钱 + 饮料的价钱。
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +  " 加摩卡 ";
    }
}


class Bubble extends Condiment {

    public Bubble(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        return 0.5 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 加泡沫 ";
    }
}

//=======================以上为开发作者=======================

/// 新增一个饮料：
class  Tea extends Beverage {

    public Tea() {
        super("茶");
    }

    @Override
    public double cost() {
        return 5.0 ;
    }
}
/// 新增一个调料 枸杞
class  Gouqi extends  Condiment {

    public Gouqi(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        /// 枸杞2元
        return 2 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "  加枸杞 ";
    }
}



public class AppTest {
    public static void main(String[] args) {

        // 加牛奶的无咖啡因饮料
        Beverage b1 = new Milk(new Decaf());

        //  再加 摩卡
        Beverage b2 = new Mocha(b1);

        // 再加个泡沫
        Beverage b3 = new Bubble(b2);



        System.out.println(b1.getDescription() +  " " + b1.cost());
        System.out.println(b2.getDescription() +  " " + b2.cost());
        System.out.println(b3.getDescription() +  " " + b3.cost());

        /// 奶茶：
        Beverage milkTea  = new Milk(new Tea());
        System.out.println(milkTea.getDescription() +  " : " + milkTea.cost());

        // 奶茶再加枸杞
        Beverage gouqi = new Gouqi(milkTea);
        System.out.println(gouqi.getDescription() +  " : " + gouqi.cost());

    }
}

/**
 * 优点:
 * 加一个饮料 ，不会违反开闭原则：比如加个饮料茶Tea
 * 加一个调料类 ， 也不会违反开闭原则。比如价格 GouQi
 *
 * 缺点会生成很多小类，不懂这个设计模式 让人迷惑。
 *
 *
 * 缺点:
 *

 */
