package mj_java_01.a15_泛型_Generic.b_泛型方法.b_泛型方法示例;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        //集合中的 泛型是Box,Box 中的元素是 Integer .
        List<Box<Integer>> boxes = new ArrayList<>();
        //完整写法.✅
        AppTest.<Integer>addBox(10, boxes);

        // 传参数 编译器可以推断.
        addBox(11, boxes);
        addBox(22, boxes);
        addBox(33, boxes);

        /** 返回值也是可以推断类型的
         * Collections  的 emptyList方法.那么没有入参怎么知道类型的呢
         * 返回值也是可以推断出类型的.
         *  public static final <T> List<T> emptyList() {
         *         return (List<T>) EMPTY_LIST;
         *     }
         */
        List<String> list1 = Collections.emptyList();
        List<Integer> list2 = Collections.emptyList();

    }

    /**
     *
     * 返回值 前面写上泛型参数 <> 泛型标志
     */
    static <T> void addBox(T ele, List<Box<T>> boxes) {
        // box 中的 element 就是 和 ele 是一个类型
        Box<T> box = new Box<>(ele);
        boxes.add(box);
    }

}
class Box<E> { //这个泛型参数必须和实例挂钩.必须先 new 一个实例 ,E 才能确定类型 .
    private E element;
    public Box() {}
    public Box(E element) {
        this.element = element;
    }

}
