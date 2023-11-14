package tujie_sheji_moshi.a09_Bridge桥接设计模式.msb.ver04;

/**
 * 礼物的具体实现
 */
public class Book extends GiftImpl {
    @Override
    String concreteGiftName() {
        return "Book📚";
    }
}
