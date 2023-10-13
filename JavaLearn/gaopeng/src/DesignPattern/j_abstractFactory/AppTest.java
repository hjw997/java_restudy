package DesignPattern.j_abstractFactory;


/**
 * 针对 工厂方法的问题:当有多个产品等级时(食物,饮料,甜品..) 工厂类 就很多.
 *  产品等级扩展时候类爆炸
 *  修改代码如下 抽象工厂的 设计模式
 */


/**
 * 抽象产品
 */
interface Food {
    void  eat();
}

/**
 * 具体类
 */
class Hamburger implements Food {
    @Override
    public void eat() {
        System.out.println("吃汉堡包");
    }
}
/// 米线
class RiceNoodle implements Food {
    @Override
    public void eat() {
        System.out.println("过桥-米线");
    }
}


/**
 * 新增一个产品等级饮料:
 */
interface Drink {
    void drink();
}

class IcePeak implements Drink {
    @Override
    public void drink() {
        System.out.println("喝一口冰峰");
    }
}

class Cola implements Drink {

    @Override
    public void drink() {
        System.out.println("喝可口可乐");
    }
}


interface Factory { //抽象工厂.没有说具体生产什么.
    Food getFood();
    Drink getDrink();
    //这里是一套产品簇要生产的 产品
}


class KFCFactory implements  Factory {

    @Override
    public Food getFood() {
        return new Hamburger();
    }

    @Override
    public Drink getDrink() {
        return new Cola();
    }
}

class SanQinFactory implements Factory {

    @Override
    public Food getFood() {
        return new RiceNoodle();
    }

    @Override
    public Drink getDrink() {
        return new IcePeak();
    }
}

/***
 * 比如这里是使用这些工厂和产品的业务代码..
 */
class  Bussiness {
    public static void taste(Factory factory) {
        Food food1 = factory.getFood();
        Drink drink1 = factory.getDrink();
        System.out.println("评委1 品尝");
        food1.eat();
        drink1.drink();

        Food food2 = factory.getFood();
        Drink drink2 = factory.getDrink();
        System.out.println("评委2 品尝");
        food2.eat();
        drink2.drink();
    }
}

//------------------时空线-----以上是作者--------------

//客户端新增了一个产品簇(比如:凉皮+ 奶茶)
class LiangPi implements Food {
    @Override
    public void eat() {
        System.out.println("三秦凉皮");
    }
}

class MilKTea implements Drink {

    @Override
    public void drink() {
        System.out.println("喝奶茶");
    }
}
/**以上 凉皮 和 奶茶 两个产品等级,但是是一个产品簇 中的东西.
 */

/**
 * 此时扩展 不用去动 时空线以上 作者的代码了 ✅
 */
class BaoJiFactory implements Factory { //扩展一个生产产品簇的工厂.

    @Override
    public Food getFood() {
        return new LiangPi();
    }

    @Override
    public Drink getDrink() {
        return new MilKTea();
    }

}

public class AppTest {
    public static void main(String[] args) {

        Bussiness.taste(new KFCFactory());
        System.out.println("--------------------");
        Bussiness.taste(new SanQinFactory());
        System.out.println("--------------------");


        /// 此处这里 很好的把自己扩展的 东西扩展进去.
        Bussiness.taste(new BaoJiFactory());
    }
}

/**
 *  PS:设计模式中什么场景用什么设计模式 要权衡.
 *  比如 只有一个产品等级:用工厂方法 好扩展.
 *  抽象工厂设计模式 能减少类的数量.
    抽象工厂的优点:
    1.仍然有简单工厂和工厂方法的优点, 具体类名和客户端解耦,扩展性也好
    2.更重要的是,抽象工厂把工厂类的数量减少了,无论有多少个产品等级,工厂就一套.(一套工厂生产抽象工厂中的产品)

    杠点:
     1.为什么三秦工厂,就必须是米线搭配冰峰呢? 为什么就不能是米线搭配可乐?
        看ReadMe中的 产品簇的概念.
            产品簇:多个有内在联系的,或者是有逻辑关系的产品.
            比如三秦套餐中:凉皮 + 冰峰 + 肉夹馍. 联合起来是个产品簇. (要看需求 螺丝螺母更具说服力.)
        解释:抽象工厂中,可以生产多个产品,这个产品之间,必须有内在联系.

        什么叫产品等级? 看图解产品等级和产品簇的概念的图

        同一个工厂中的产品(看图解图片)都属于同一个产品簇.
        不能把不同产品簇混合到一个抽象工厂的实现类中. 什么工厂就生产什么产品簇.

     2.多加产品簇 是 比较好扩展的.

    缺点:
    1.当产品等级发生变化时,增加或删除 产品等级,都要引起以前所有工厂代码的修改.
     违反了开闭原则.

  结论:当产品等级比较固定时候,可以考虑使用抽象工厂.
       如果产品等级经常变动,则不建议使用抽象工厂. 所以使用看场景.
       动态工厂 + 反射 : Spring 能解决.
 */

