package mj_java_01.a10_数字.b_自己将基本类型包装为引用类型;


/**
 * 自定义 一个引用类型,把 int 基本类型包装进去.
 * 包装类 也就是 这个原理:
 */
public class IntObject {
    public int getValue() {
        return value;
    }
    private final int value;

    public IntObject(int value) {
        this.value = value;
    }
}
