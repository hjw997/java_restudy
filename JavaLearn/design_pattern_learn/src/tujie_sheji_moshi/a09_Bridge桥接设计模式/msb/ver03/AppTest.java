package tujie_sheji_moshi.a09_Bridge桥接设计模式.msb.ver03;

/**
 * ReadMe : 如果礼物分为 温柔型 和 狂野型的
 *  * WarmGift WildGift
 *  * 这时 Flower 应该分为:
 *  * WarmFlower  WildFlower
 *  * Book 应该分为:
 *  * WarmBook WildBook

 *
 * 就说 WarmFlower 来说吧:
 * public class WarmFlower extends Flower { }
 *  * 或者从 WarmGift 继承.
 *  * 或者从 Flower 继承.
 *
 *   *  *
 *  *  * 如果再有别的礼物,比如 抽象类型 : ToughGift(硬汉型)  ColdGift(冷酷型)
 *  *  * 或者具体某种实现: Ring Car
 *  *  * 就会产生类爆炸💥 :
 *  *  * WarmCar ColdRing  WildCar WildFlower ....
 *
 * 最大的问题就是:⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️
 *  抽象的部分在发展(温暖型,冷酷型,硬汉型) , 实现的部分也在发展(具体的如 Book Flower , Car , Ring)  ,
 *  每增加一种抽象型:(比如增个狂野型) 那么就会出现 狂野型Book 狂野型Car  狂野型Ring 狂野型Flower 等等.
 *  一组合 就会类爆炸.
 *  解决这个问题就是桥接模式.
 *  分离抽象与具体,用聚合方式(桥) 链接 抽象与具体. 看 ver04包.
 */
public class AppTest {
    public static void main(String[] args) {

    }
}
