package mj_java_01.a07_抽象类_接口_多态.b_接口.e_接口升级;

interface JiajiaoAble {
    /**
     * 该开始这个接口有个方法 教篮球. 比如很多个类实现了这个接口.
     */
    void teachFootBall();

    /**
     * 现在随着开发升级,接口需要升级一下,也就是此时如果定义一个新方法,那么原来的实现了这个接口的所有的类都要去实现.
     * 这样会导致大幅度代码改动,以前实现接口的类都要改动.
     * 若现在不改动以前的实现类的前提下进行接口升级,从java8 开始,有2种 方案:
     * > 默认方法:(default method)
     * > 静态方法:(static method)
     */
    default void teachBasketBall() {
        System.out.println("家教接口--默认实现教🏀");
    }
}

class Student implements JiajiaoAble {
    @Override
    public void teachFootBall() {
        System.out.println("------学生开始教足球------");
        System.out.println("学生-教美式⚽️足球");
    }
}

class Teacher implements JiajiaoAble {

    @Override
    public void teachFootBall() {
        System.out.println("------老师开始教足球------");
        System.out.println("老师-教英式 ⚽️足球");
    }

    @Override
    public void teachBasketBall() {
        System.out.println("------老师开始教篮球------");
        JiajiaoAble.super.teachBasketBall(); //注意这种写法:调用接口中的默认实现功能
        /**在父接口的基础上 加自己功能*/
        System.out.println("老师-教🏀篮球");
    }
}

public class AppTest {
    public static void main(String[] args) {
        testJiajiao(new Student());
        System.out.println("-------------------👩🏻‍🏫开始教----------------");
        testJiajiao(new Teacher());
    }

    public static void testJiajiao(JiajiaoAble jiajiao) {
        jiajiao.teachBasketBall();
        jiajiao.teachFootBall();
    }
}
