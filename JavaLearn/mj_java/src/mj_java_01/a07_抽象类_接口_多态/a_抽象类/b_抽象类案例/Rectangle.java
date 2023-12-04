package mj_java_01.a07_抽象类_接口_多态.a_抽象类.b_抽象类案例;

public class Rectangle extends Shape {
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    /**为何还要final 记得吗? final 一次赋值(之后不能修改),只要对象初始化完后必须有值.*/
    private final double width; //宽
    private final double height; //高

    public Rectangle() {
        this(0,0);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected void calculate() {
        girth = 2 * (width + height);
        area = width * height;
    }

    @Override
    void calculateTest() {

    }
}
