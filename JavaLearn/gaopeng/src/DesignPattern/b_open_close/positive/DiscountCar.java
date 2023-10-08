package DesignPattern.b_open_close.positive;

public class DiscountCar extends Car{
    @Override
    public double getPrice() {
        /// 在这里扩展功能,而不会影响 之前的类的功能.
        return super.getPrice() * 0.8  ;
    }
}
