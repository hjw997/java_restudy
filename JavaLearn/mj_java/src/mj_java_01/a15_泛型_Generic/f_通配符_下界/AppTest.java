package mj_java_01.a15_泛型_Generic.f_通配符_下界;

public class AppTest {
    public static void main(String[] args) {

        Box<Integer> box1 = null;
        Box<Number> box2 = null;

        Box<? super Integer> box3 = null;

        //Box的泛型 是 Number 或者 Number的父类型.
        Box<? super Number> box4 = null;

        testLower(box1);
        testLower(box2);
        testLower(box3);
        testLower(box4);  //testLower要求的是参数泛型是 Integer 或者 Integer的父类型 OK✅.

    }


    /**
     *  super 下界 : 大于等于 它
     *  可以通过 super 设置类型参数的下界.
     *  如下: Box<? super Integer>
     *      类型参数 必须是 Integer 类型,  或者 是Integer的 父类型.
     *
     *
     */
    static void testLower(Box<? super Integer> box) {

    }
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


