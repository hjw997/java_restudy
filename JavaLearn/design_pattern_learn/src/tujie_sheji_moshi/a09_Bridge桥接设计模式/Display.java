package tujie_sheji_moshi.a09_Bridge桥接设计模式;

public class Display {
    private final DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    /**
     * 语法复习:
     * final :
     * 修饰的方法不能被重写.
     * 修饰的类不能被继承.
     * 修饰的变量,只能进行1次赋值.
     */
    public final void display() {
        open();
        print();
        close();
    }
}
