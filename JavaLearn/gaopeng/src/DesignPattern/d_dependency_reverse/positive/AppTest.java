package DesignPattern.d_dependency_reverse.positive;


interface Animal{
    void eat();
}

/// 人和狗 : 人是上层 狗是下层.
class Person {
    public void feed(Animal animal) {

        animal.eat();

    }

}

class Dog implements Animal{
    public void eat() {
        System.out.println("狗啃骨头");
    }
}

/**
 * 依赖倒置:
 *        上层不能依赖于下层
 *        它们都应该依赖于抽象
 *
 * 什么是上层? 什么是下层?
 * 调用 别的方法就是上层
 * 被其他方法调用 的 就是下层.
 */

//---------------------客户端以下是---------------------------

/**
 * 变化来了 , 客户端 不仅需要喂狗,还要喂猫.
 * 客户端自己定义一个猫类.
 */
class Cat implements Animal{
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

// 新增老虎类
class Tiger implements Animal {

    @Override
    public void eat() {
        System.out.println("老虎吃🐔");
    }
}

public class AppTest {

    public static void main(String[] args) {
        Person person = new Person();
        Dog dog = new Dog();
        person.feed(dog);

        /// 下面新增一个动物类 就不用修改 作者源代码.

        /// 现在如果继续扩展新增的类,就不用修改 作者源代码.
        Cat cat = new Cat();
        person.feed(cat);

        //比如新增一个老虎类.
        Tiger tiger = new Tiger();
        person.feed(tiger);

    }
}
/**
 * 这种代码 符合 依赖倒置: ✅
 * 因为每当下层变动时候 ,上层都要跟着 一起变动.
 * 底层多个 动物 ,上层就要不断的 动代码变动
 * 我们希望:
 * 下层新增一个动物时,上层应该"不知道" ,上层代码应该不用改动.
 * 请看正例包.
 */
