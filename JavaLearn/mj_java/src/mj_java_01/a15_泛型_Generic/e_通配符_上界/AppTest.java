package mj_java_01.a15_泛型_Generic.e_通配符_上界;

import org.junit.Test;

public class AppTest {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        Box<Number> box2 = new Box<>();
        testUpper(box1);
        testUpper(box2);

        //Box的泛型类型是 Number 或者 Number 的子类型
        Box<? extends Number> box3 = null;
        box3 = box1;
        testUpper(box3);

        //Box的 泛型是 Integer 或者 Integer的子类型.
        Box<? extends Integer> box4 = null;
        //box4 = box2; 报错❌

        //下面这个box4 传入✅ 理解:
        // box4 的 泛型是 Integer 或者 Integer的子类型,
        // 符合 testUpper 方法的 上界, 是Number , 或者Number的子类.所以可以传入.
        testUpper(box4);

    }

    /**
     * Box 的泛型类型是 Number 或者 Number的 子类. 上界.到顶就是Number .
     * @param box
     */
    static void testUpper(Box<? extends Number> box) {

    }

    @Test
    public void test03() {
        Box<String> box1 = new Box<>();
        Box<Integer> box2 = new Box<>();
        Box<Double> box3 = new Box<>();
        //showBox03(box1); //也可以起到限制类型的作用.
        showBox03(box2);
        showBox03(box3);
    }

    /**
     * 使用通配符 做限制
     * 通过 extends 设置类型参数的上界
     * 上界 顶头了 就是 Number .
     * 所以 表达的就是 类型参数 是 Number 或者 Number的子类型
     * @param box
     */
    static void showBox03(Box<? extends Number> box) {

    }

    @Test
    public void test02() {
        Box<String> box1 = new Box<>();
        Box<Integer> box2 = new Box<>();
        Box<Double> box3 = new Box<>();

        //showBox02(box1); //报错❌ 传不进去
        showBox02(box2);
        showBox02(box3);
    }

    /**
     * 限制 只能传入 Number 或者 子类型的 T .
     * @param box
     * @param <T>
     */
    static <T extends Number> void showBox02(Box<T> box) { }

    @Test
    public void test01() {
        Box<String> box1 = new Box<>();
        Box<Integer> box2 = new Box<>();
        Box<Object> box3 = new Box<>();
        showBox01(box1);
        showBox01(box2);
        showBox01(box3);
    }
    //可以使用任何类型
    static <T> void showBox01(Box<T> box) { }




}
class Box<E> {
    private E element;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}

