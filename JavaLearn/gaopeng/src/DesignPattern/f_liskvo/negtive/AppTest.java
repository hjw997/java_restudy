package DesignPattern.f_liskvo.negtive;


/**
 * 继承的作用:
 * 1.提高代码重用性
 * 2.多态的前提.
 *
 * 两个类能不能发生继承关系的依据是什么?
 *  a.主要看有没有 "is a" 关系
 *  b.在两个类有了 is a 关系后, 还要考虑子类对象在替换了父类对象之后业务逻辑是否发生变化,如果变化,则不能发生继承关系.
 *
 *  正方形 和 长方形 有 is a 关系. 可以把正方形看成 是特殊的 长方形. 那么我们能不能让正方形类直接就去继承长方形类呢? 现在不能了.
 *  为什么? 因为还要考虑业务场景,看看在特定的业务场景下, 正方形能替换了 长方形 以后,业务逻辑是否变化!
 *
 */

class Rectangle {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}

class Utils {
    /**
     * 功能让一个 长方形变形为正方形.
     * @param r
     */
    public static void transform(Rectangle r) {
        while (r.getWidth() <= r.getLength()) {
            r.setWidth(r.getWidth() + 1);
            System.out.println(r);
        }
    }
}

/// 正方形 is a 是一个长方形.
class Square extends Rectangle {
    private double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getLength() {
        return sideLength;
    }

    @Override
    public void setLength(double length) {
        this.sideLength = length;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public void setWidth(double width) {
        this.sideLength = width;
    }
}

public class AppTest {
    public static void main(String[] args) {
//        Rectangle r = new Rectangle();
//        r.setWidth(12);
//        r.setLength(20);
//        //让长方形变为正方形
//        Utils.transform(r);

        //Rectangle r = new Rectangle();
        Rectangle r = new Square(); //这里用子类替换了父类发现业务和原来不一样了.
        /**
         * 尽管这里有 is a 关系,但是业务的不同 ,所以不能继承.
         * 鸵鸟 飞鸟.
         */
        r.setWidth(12);
        r.setLength(20);
        //还是调用变形--直接变为了死循环.
        Utils.transform(r);



    }
}
