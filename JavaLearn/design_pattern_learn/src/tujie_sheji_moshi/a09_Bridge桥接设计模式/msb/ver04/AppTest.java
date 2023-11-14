package tujie_sheji_moshi.a09_Bridge桥接设计模式.msb.ver04;


/**
   看ReadMe 和 图解.
 */
public class AppTest {
    public static void main(String[] args) {
        GeGe geGe = new GeGe("Jack");
        MeiMei meimei = new MeiMei("Rose");

        //用聚合 代替继承
        Gift gift1 = new WarmGift(new Book());
        Gift gift2 = new WildGift(new Flower());
        geGe.chase(meimei, gift1);
        geGe.chase(meimei,gift2);

        /**
         Jack gave gift: 温暖型礼物:{impl=Book📚} to Rose
         Jack gave gift: 狂野型礼物{impl=🌺花儿} to Rose
         */
    }
}
