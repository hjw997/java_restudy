package tujie_sheji_moshi.a09_Bridge桥接设计模式;

/**
 * 类的 实现层次结构:
 * 桥的另一侧. 位于"类的实现层次结构" 的最上层.
 * 抽象类,三个抽象方法.
 */
public abstract class DisplayImpl {
    public abstract void rawOpen();

    public abstract void rawPrint();

    public abstract void rawClose();

}
