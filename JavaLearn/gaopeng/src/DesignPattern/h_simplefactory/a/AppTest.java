package DesignPattern.h_simplefactory.a;

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


//------------------时空线-----以上是作者--------------
public class AppTest {
    public static void main(String[] args) {

        Food food = new Hamburger();// 如果作者 修改了类名, 那么这里客户端就报错了.违反了迪米特法则.
        /// 向上转型时候,调用的方法之和 new 的对象有关.
        food.eat();
    }
}
/**
 * 这种设计相当脆弱: 为什么呢? 因为只要作者修改了具体产品的类名,那么客户端代码,也要随之一起改变.
 * 这样服务器端代码 和 客户端 代码就是 耦合的.
 * 我们希望的效果是:无论服务器端代码如何修改,客户端 代码 都应该不知道,不用修改客户端代码.
 *
 */