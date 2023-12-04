package mj_java_01.a07_抽象类_接口_多态.b_接口.c_接口的细节;


public class a_父类和接口中的方法签名一样时候的要求 {
}

interface Eatable {
    void eat(String food);
}
class Animal {
//    public int eat(String food) {
//        return food.length();
//    }
    //父类的方法和 接口中定义的方法 方法签名一样 那么返回值类型也必须一样. 否则如上: 报错❌
    public void eat(String food) {
        /**父类的方法和接口中的方法签名一样时候容易引起歧义会报错,所以返回值类型必须也要一样.*/
    }
}


/** 接口 和 继承 的区别:
 * 接口 代表你会什么东西.会哪些能力,接口一般放一些行为,一些能力,能干什么.
 * 继承是代表: 你是一个什么东西. 是 is-a 的关系.
 */
 class Dog extends Animal implements Eatable {

    @Override
    public void eat(String food) { //

    }

//    @Override
//    public int eat(String food) {
//        super.eat(food);
//        return 10;
//    }
    //父类的方法和 接口中定义的方法 方法签名一样 那么返回值类型也必须一样. 否则如上: 报错❌

}

