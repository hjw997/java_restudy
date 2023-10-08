package DesignPattern.b_open_close.negtive;

public class Car {

    private String brand;
    private String color;
    private boolean louyou;
    private double price;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLouyou() {
        return louyou;
    }

    public void setLouyou(boolean louyou) {
        this.louyou = louyou;
    }

    public double getPrice() {
//        return price;
        return price * 0.8 ; //反例直接来代码中修改. 打8折.
        // 违反开闭原则.
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", louyou=" + isLouyou() +
                ", price=" + getPrice() +
                '}';
    }
}
