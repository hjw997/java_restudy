package tujie_sheji_moshi.a09_Bridge桥接设计模式.msb.ver04;

/**
 * 一个 哥哥对象 追美眉的一个例子.
 */
public class GeGe {
    public GeGe(String name) {
        this.name = name;
    }
    private String name;

    public void chase(MeiMei meiMei, Gift gift) {
        give(meiMei,gift);
    }

    private void give(MeiMei meiMei, Gift gift) {
        System.out.println(name + " gave " + "gift: " + gift +  " to " + meiMei.getName() );
    }
}
