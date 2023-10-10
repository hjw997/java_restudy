package DesignPattern.i_factorymethod;


/**
 * 针对 简单工厂中的 问题:比如客户端扩展一个产品 凉皮 ,要去动作者代码.
 * 修改代码如下 使用工厂方法 设计模式
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


interface FoodFactory { //这里改为了一个interface
    Food getFood();
}

class HamburgerFactory implements  FoodFactory {

    @Override
    public Food getFood() {
        return new Hamburger();
    }
}

class RiceNoodleFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new RiceNoodle();
    }
}
/***
 * 比如这里是使用这些工厂和产品的业务代码..
 */
class  Bussiness {
    public static void taste(FoodFactory foodFactory) {
        Food food1 = foodFactory.getFood();
        System.out.println("评委1 品尝");
        food1.eat();

        Food food2 = foodFactory.getFood();
        System.out.println("评委2 品尝");
        food2.eat();
    }
}

//------------------时空线-----以上是作者--------------

//客户端新增了一个产品凉皮
class LiangPi implements Food {
    @Override
    public void eat() {
        System.out.println("三秦凉皮");
    }
}

/**
 * 此时扩展 不用去动 时空线以上 作者的代码了 ✅
 */
class LiangpiFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new LiangPi();
    }
}

public class AppTest {
    public static void main(String[] args) {
        /// 上层(调用方) 不知道下层的具体实现
        //FoodFactory foodFactory = new HamburgerFactory(); /// 发生向上转型

        //FoodFactory foodFactory = new RiceNoodleFactory(); /// 此时这里只改一行. 和 new 的对象 其他不动.

        // 此时如果扩展 用户扩展的 产品
        FoodFactory foodFactory = new LiangpiFactory();

        Food food = foodFactory.getFood(); //向上转型发生时候 调用方法是 new 的对象有关系.

        food.eat();


        Bussiness.taste(new HamburgerFactory());
        System.out.println("--------------------");
        Bussiness.taste(new RiceNoodleFactory());
        System.out.println("--------------------");
        /// 此处这里 很好的把自己扩展的 东西扩展进去.
        Bussiness.taste(new LiangpiFactory());
    }
}

/**
 * 工厂方法:
 *   优点:
 *   1.仍然具有简单工厂的优点,服务器端修改了具体产品的类名以后,客户端不知道.
 *   2.当客户端需要扩展一个新的产品时,不需要修改作者原来的代码,只是扩展一个新的工厂而已.
 *
 *   杠点:
 *      1.我们已经知道 简单工厂也好 工厂方法也好,都有一个优点,服务器端的具体产品类名发生变化以后,客户端不知道.
 *
 *      但是反观 我们的代码 ,客户端任然依赖于具体的工厂类名呀! 此时如果服务器端修改了具体工厂的类名,那么客户端也要随之一起修改.
 *      感觉折腾了一圈 又回到了原点.
 *      解释:
 *          工厂的名字,是被视为接口的, 作者有责任,有义务保证工厂的名字是稳定的. 也就是说虽然客户端依赖于工厂的具体的类名,可在编程界内
 *          所有的工厂名字都是趋向于稳定(并不是100%不会变)至少工厂的类名,要比具体的产品类的名字更加稳定.(一种合作方式)
 *
 *     2.既然产品是客户端扩展出的,那为什么不自己实例化呢? 毕竟扩展出的 凉皮这个产品我们自己就是作者.
 *       Food food = new LiangPi(); 这样子呢?
 *      → 因为我们自己能把控,为什么自己还要个 工厂类去返回 产品对象呢?
 *        因为作者在开发功能时,不仅仅开发抽象产品或具体产品,还会配套的搭配一些做好的 框架 配套的业务.
 *        比如 Bussiness 类 中 taste 品尝 参数是个 食物工厂.
 *
 *     3.现在制作LpFactory 是为了能把LpFactory 传入Bussiness.taste方法, 所以,必须定义这个LpFactory.
 *       那么为什么不直接在Bussiness.taste 开始传入 Food 呢?
 *     → 因为 Bussiness.taste 的方法是调用方, 调用方就是上层,上层不能依赖具体实现,而是依赖抽象.
 *       工厂方法是我们约定的承诺,工厂暴露的方法要比实际产品要稳定.
 *
 *     缺点:
 *     如果有多个产品等级,那么工厂的数量,就会爆炸式增长.
 *     现在的案例中只有一个产品等级-食物.
 *     如果来个饮料-产品等级 那么对应就会扩展出很多产品和工厂类.
 *     为了客服这个缺点--> 使用抽象工厂看 j_abstractFactory 包.
 */

