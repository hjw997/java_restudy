package mj_java_01.a07_抽象类_接口_多态.a_抽象类.b_抽象类案例;

public class Circle extends Shape {
    /**
     * 圆有自己属性:半径
     */
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculate() {
        //圆面积: π*r*r
        area = Math.PI * radius * radius;
        //圆周长: 2πr
        girth = 2 * Math.PI * radius;
    }

    @Override
    void calculateTest() {

    }
}
