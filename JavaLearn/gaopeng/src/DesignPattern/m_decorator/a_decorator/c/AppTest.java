package DesignPattern.m_decorator.a_decorator.c;

/**
 * 业务场景:星巴克卖咖啡,因为所有咖啡一开始,只有图里的 4中 咖啡 : Decaf Espresso DarkRoast HouseBlend
 * 因为所有咖啡都有共性: 所以开发人员把他们共性上提到一个父类中 Beverage (除水以外的饮料)
 * 针对 b 包中的问题, 我们 何必为每一种 咖啡加每一种调料都创建一个类呢? 这样做太笨了.
 * 我们可以直接在父类 Beverage 中添加 4 个 boolean 属性, 分别 代表4中调料.
 */
abstract class Beverage {
    private boolean isMilk; //是否加牛奶
    private boolean isSoy;  //是否豆浆
    private boolean isMocha; //是否加摩卡
    private boolean isBubble;//是否要加泡沫

    private boolean isGouqi;//❌用户想要扩展个枸杞.比如开了个分店自己加个枸杞. 总店给你的字节码 无法改动.
    //❌ 计算有源代码也不要动. 这里 改写 getDescription 和 cost()计算加入调料枸杞的代码不再演示.违反开闭原则.

    public boolean isMilk() {
        return isMilk;
    }

    public void setMilk(boolean milk) {
        this.isMilk = milk;
    }

    public boolean isSoy() {
        return isSoy;
    }

    public void setSoy(boolean soy) {
        this.isSoy = soy;
    }

    public boolean isMocha() {
        return isMocha;
    }

    public void setMocha(boolean mocha) {
        this.isMocha = mocha;
    }

    public boolean isBubble() {
        return isBubble;
    }

    public void setBubble(boolean bubble) {
        this.isBubble = bubble;
    }


    public String getDescription() {
        String str = description;
        if (isMilk) {
            str += " 加牛奶(0.2)";
        }
        if (isSoy) {
            str += " 加豆浆(0.3)";
        }
        if (isMocha) {
            str += " + 加摩卡(0.4)";
        }
        if (isBubble) {
            str += " + 加泡沫(0.1)";
        }

        return str;
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
    //public abstract double cost();
    //此时父类就要把 花费的调料在父类中算出
    public double cost() {
        double total = 0;
        if (isMilk) {
            total += 0.2;
        }
        if (isSoy) {
            total += 0.3;
        }
        if (isMocha) {
            total += 0.4;
        }
        if (isBubble) {
            total += 0.1;
        }
        return total;
    }


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
        //咖啡本身价格 + 调料的价格(调料价格在父类中计算)
        return 1.0 + super.cost();
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
        //本身价钱 +  调料价格
        return 2.0 + super.cost();
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
        //本身价钱 +  调料价格
        return 1.5 + super.cost();
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
        //本身价钱 +  调料价格
        return 3.0 + super.cost();
    }
}

//========================时空线-------------
class Tea extends Beverage {

    Tea() {
        super(" 茶");
    }

    @Override
    public double cost() { //茶的价钱
        //自身价格 + 调料的花费
        return 2.0 +  super.cost();
    }
}

/**
 * 用户自己
 */

public class AppTest {
    public static void main(String[] args) {
        Beverage beverage = new Decaf();
        //只需要这里 标记就想 服务员点餐 ✅ 打钩一样
        beverage.setMilk(true); //加牛奶
        beverage.setSoy(true); // 加豆浆
        beverage.setBubble(true); //加泡沫

//        Beverage beverage1 = new Espresso();
//        Beverage beverage2 = new DarkRoast();
//        Beverage beverage3 = new HouseBlend();

        System.out.println(beverage.getDescription() + " : " + beverage.cost());
//        System.out.println(beverage1.getDescription() + " : " + beverage1.cost());
//        System.out.println(beverage2.getDescription() + " : " + beverage2.cost());
//        System.out.println(beverage3.getDescription() + " : " + beverage3.cost());
    }
}
/**
 优点:
 1.类没有爆炸,没有出现各种各样的类.
 2.变化来了,星巴克老板,又加入一个新的饮料 : 茶 好拓展. 符合开闭原则.

 缺点:
 变化来了,星巴克老板,又加入一个新的 调料,
 就要 重新改写父类Beverage 的 getDescription 和 cost 计算调料价格 的方法..
 这样 ❌违反开闭原则. 看 d 包.
 */