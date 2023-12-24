package mj_java_01.a15_泛型_Generic.b_泛型方法.c_泛型方法细节_静态方法不能用泛型类的泛型参数;

/**
 * 注意细节:
 * 泛型类型不能做静态方法的泛型方法的泛型参数:
 */
public class AppTest {
    public static void main(String[] args) {

        /**
         * 泛型类型的 泛型参数只能用在实例方法上 ,不可以用在静态方法上
         * 原因:
         *      说白了,类型旁边的 泛型参数是用来创建对象的时候用的.
         */
        Box<String> box1 = new Box<String>();
        Box<Integer> box2 = new Box<Integer>();
        //可以从上看出 泛型类型的 泛型参数必须和实例挂钩,从上box1 box2 看出,每个实例都挂钩一个泛型参数.

    }
}

class Box<E> { //这个泛型参数必须和实例挂钩.必须先 new一个实例 ,E 才能确定类型 .
    private E element;
    public Box() {}
    public Box(E element) {
        this.element = element;
    }

    /**
     * 细节: 泛型类型的 泛型参数只能用在实例方法上 ,不可以用在静态方法上
     * 说白了 类型旁边的 泛型参数是用来创建对象的时候用的.
     * 泛型类型的 泛型参数必须和实例挂钩,从上box1 box2 看出,每个实例都挂钩一个泛型参数.
     * 所以 这个 E 不能用在 静态方法上. 你连 Box 不存在,所以哪里来的E 参数呢.
     */
    // public static void print(E element) { } //报错 ❌

    /**
     * 静态方法 想要支持泛型,只能自己去写.⚠️⚠️
     */
    public static <T> void show(T element) { //✅
        System.out.println(element);
    } // 通过以上分析 静态泛型方法 这样是可以的


}
