package mj_java_01.a15_泛型_Generic.a_泛型类型_使用了泛型的类或者接口.c_原始类型_RawType;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 什么是原始类型:
         * 没有传递具体的类型参数 给泛型的类型参数.
         */
        //Box 称为 Box<E> 的原始类型.
        Box rawBox = new Box(); // 原始类型 .
        Box<String> strBox = new Box<>(); // 非原始类型.
        strBox = rawBox;
        rawBox = strBox;

        // 原始类型Box rawBox  和 Box<Object>  区别.
        Box<Object> rb = new Box<>(); //⚠️: 非原始类型. 和 Box rawBox 不是统一种类型.
        rb = rawBox;

        //rawBox 虽然没有传 泛型类型参数 ,但是 setElement 代码提示 Object 类型
        //rawBox.setElement();
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
