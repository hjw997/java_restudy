package tujie_sheji_moshi.a09_Bridge桥接设计模式;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(new StringDisplayImpl("Hello,China"));
        Display display2 = new CountDisplay(new StringDisplayImpl("Hello,World!"));
        CountDisplay display3 = new CountDisplay(new StringDisplayImpl("Hello,Universe."));

        display1.display();
        display2.display();
        display3.display();

        //调用扩展功能
        display3.multiDisplay(5);
        /** 打印结果:
         +-----------+
         |Hello,China|
         +-----------+
         +------------+
         |Hello,World!|
         +------------+
         +---------------+
         |Hello,Universe.|
         +---------------+
         +---------------+
         |Hello,Universe.|
         |Hello,Universe.|
         |Hello,Universe.|
         |Hello,Universe.|
         |Hello,Universe.|
         +---------------+
         */

    }
}
