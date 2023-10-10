package DesignPattern.h_simplefactory.b;


/**
 * 针对 a 包中的问题,服务器端代码一旦改动产品名称,客户端代码也要跟着修改 (违反依赖倒置原则)
 * 修改 代码如下 ,使用 简单工厂设计模式.
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
 * 作者做了个 工厂方法 暴露给外面用.
 * 其实 所谓的分 , 中间一定是连着的, 只是 分开后 变的低耦合了
 */
class FoodFactory {
    /// 这个是 作者留给 外界调用的接口.
    public static Food getFood(int n) { // 这个暴露的方法也是接口, 不仅是interface 是接口.
        Food food = null;
        switch (n) {
            case 1:
                food = new Hamburger();
                break;
            case 2:
                food = new RiceNoodle();
                break;
            //现在这里 作者如果有新的产品 就继续在这里加就好 , 从而不会 影响到 调用代码.
            /// 客户端扩展一个产品凉皮? ❌ .
        }
        return food;
    }
}


//------------------时空线-----以上是作者--------------

//客户端新增了一个产品凉皮
class LiangPi implements Food {
    @Override
    public void eat() {
        System.out.println("三秦套餐");
    }
}
public class AppTest {
    public static void main(String[] args) {
        /** 调用方叫 上层, 上层现在通过一个工厂暴露的接口 隔离开了 底层具体实现的类.  */
        Food food = FoodFactory.getFood(1); ///通过 一个工厂方法暴露出去的一个接口.
        /** 现在客户端只要知道 1 对应 汉堡. */
        food.eat();

        /**
         * ❌ 问题 我客户端如果扩展了一个凉皮 LiangPi,那么 势必要改 switch 方法.
         * 很多设计模式是在没有源码的情况下设计出的.
         *
         */
    }
}
/**
 * 这就是简单工厂:
 *  优点 :
 *  1.把具体产品的类型,从客户端代码中,解耦出来了
 *  2.服务器端如果修改了具体的产品的类名,客户端也不知道.
 *  这便符合了面向"接口"编程的思想 (这里的接口 不仅仅指的是 interface,还有作者暴露给外界的调用的方法也叫接口)
 *  对外的接口要趋向于稳定. 不能一个版本改动,变了接口,那么又变得耦合.
 *
 *  缺点:
 *  1.客户端必须死记硬背 那些数字或常量 与具体产品的映射关系. 比如 1对应汉堡, 2 对应米线.
 *  2.如果具体产品特别多,则简单工厂就会变得十分臃肿. 10个 100个具体产品 则需要再简单工厂中的switch 中写出 100 个case
 *  ❌ : 最重要的是变化来了, 客户端要扩展具体产品的时候,势必要修改简单工厂中的代码,这样便违反了开闭原则.
 */
