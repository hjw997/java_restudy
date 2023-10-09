package DesignPattern.f_liskvo.supplement;


/**
 * 复习什么叫方法重写:
 * 在子类和父类中,出现了返回类型相同,方法名相同,方法参数相同的方法时,构成了方法重写
 * 方法重写的两个限制:
 *  1.子类重写父类的方法时,子类的访问修饰符不能比父类的更严格.
 *  2.子类重写父类的方法时,子类方法不能抛出比父类更多的异常. 父类抛,子类可以不抛.
 *
 *  为什么要有以上2个限制,就是为了保证在子类对象替换了父类的对象后,语法不会报错.
 *  也就是符合里氏替换原则.
 *  这里是 语法角度 保证了里氏替换原则.
 */

class Fu {
    public void f1() {

    }
}

class Zi extends Fu {
    @Override
//    protected void f1() { 修饰符不能比父类的更严格.
    public void f1() {
        super.f1();
    }
}






public class AppTest {
    public static void main(String[] args) {

    }
}
