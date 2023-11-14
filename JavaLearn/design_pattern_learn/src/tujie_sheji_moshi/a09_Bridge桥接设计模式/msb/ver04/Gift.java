package tujie_sheji_moshi.a09_Bridge桥接设计模式.msb.ver04;

/**
 * 抽象的礼物
 */
abstract class Gift {
    protected  GiftImpl impl; //每个Gift 中聚合一个具体的实现:

    public String giftName(){
       return impl.concreteGiftName();
    }

}
