package tujie_sheji_moshi.a09_Bridge桥接设计模式.msb.ver04;

/**
 * 狂野型 礼物
 */
public class WildGift extends Gift {
    public WildGift(GiftImpl impl) {
        this.impl = impl; // new 这个狂野Gift 时候聚合一个具体实现.
    }

    @Override
    public String toString() {
        return "狂野型礼物{" +
                "impl=" + giftName() +
                '}';
    }
}
