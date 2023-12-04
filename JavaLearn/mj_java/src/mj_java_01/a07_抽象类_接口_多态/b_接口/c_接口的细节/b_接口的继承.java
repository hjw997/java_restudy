package mj_java_01.a07_抽象类_接口_多态.b_接口.c_接口的细节;

public class b_接口的继承 {
}

interface Runnable { //能跑
    void run();
}

interface Playable { //能玩
    void play();
}

/**
 * 接口 是 多继承.
 */
interface Happiable extends Eatable, Runnable, Playable { //能吃才开心
    // 接口继承 相当于 所有 接口方法都 放到这里了.

    /**当多个父接口中的方法签名一样时,那么返回值类型也必须一样.
     * 比如 Eatable 中有: void eat(String food) , Runnable 也有 int eat(String food) ,
     * 此时方法签名一样了就没法区分,外加 返回值才能区分.
     */
}