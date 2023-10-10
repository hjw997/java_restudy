package DesignPattern.d_dependency_reverse.negtive;


/// 人和狗 : 人是上层 狗是下层.
class Person {
    public void feed(Dog dog) {
        dog.eat();
    }

    //为了喂猫,这里破坏了 开闭原则. 来修改作者代码
    public void feed(Cat cat) { //这里的猫就依赖了 客户端层面的 东西.
        cat.eat();
    }
}

class Dog {
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
class Cat {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class AppTest {

    public static void main(String[] args) {
        Person person = new Person();
        Dog dog = new Dog();
        person.feed(dog);

        //如果现在人要喂猫 . 没法喂. 只能修改 作者代码,添加个喂猫的 方法
        Cat cat = new Cat();
        person.feed(cat);

    }
}
/**
 * 这种代码违反了依赖倒置: ❌
 * 因为每当下层变动时候 ,上层都要跟着 一起变动.
 * 底层多个 动物 ,上层就要不断的 动代码变动
 * 我们希望:
 * 下层新增一个动物时,上层应该"不知道" ,上层代码应该不用改动.
 * 请看正例包.
 */
