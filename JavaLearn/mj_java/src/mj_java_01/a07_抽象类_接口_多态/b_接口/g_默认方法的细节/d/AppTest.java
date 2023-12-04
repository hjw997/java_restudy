package mj_java_01.a07_抽象类_接口_多态.b_接口.g_默认方法的细节.d;

interface Animal {
    default String myself() {
        return "I am an animal";
    }
}
interface FireAble extends Animal {

}
interface FlyAble extends Animal {
    @Override
    default String myself() {
        //return Animal.super.myself();
        return "I can fly";
    }
}

class Dragon implements FireAble, FlyAble {
    // 本来两个接口中都有相同的方法时候要强制重写.注意和 c 包中的例子讲到的强制重写.
    // 这里就没有强制要求重写 myself 方法,
    // 因为就就近原则 能区分 优先调用 Flyable 的 myself
}




public class AppTest {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        String self = dragon.myself();
        System.out.println(self);
    }
}
