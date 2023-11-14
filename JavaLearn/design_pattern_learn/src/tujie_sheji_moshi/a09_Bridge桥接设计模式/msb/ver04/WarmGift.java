package tujie_sheji_moshi.a09_Bridge桥接设计模式.msb.ver04;

/**
 * 温暖型礼物
 */
public class WarmGift extends Gift {
    public WarmGift(GiftImpl impl) {
       this.impl = impl;// new 这个温暖型 Gift 时候聚合一个具体实现.
    }

    @Override
    public String toString() {
        return "温暖型礼物:{" +
                "impl=" + giftName() +
                '}';
    }
}
