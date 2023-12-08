package mj_java_01.a09_枚举.c_枚举的使用注意;

/**
 * 自定义了 构造方法的枚举
 */
public enum Season {
    /**
     * PS : ✅ 每个枚举常量 就是一个 枚举的实例 对象,创建时候调用 自己的构造方法.
     */
    SPRING(5,15),
    SUMMER(20, 38),
    FALL(13, 20),
    WINTER(-10, 10);

    /***
     * 枚举类型中如果要定义 属性 或者 方法  要和最后一个常量 用 分号 ; 隔开.
     */
    private final int min;
    private final int max;

    /**
     * ⚠️ : 构造方法的 权限修饰符 不写 或者 private
     * 不能像类构造方法一样写 public 修饰符.❌
     * @param min
     * @param max
     */
    Season(int min, int max) { //⚠️:这个构造方法 外界调不了,是给初始化 枚举常量用的
        this.min = min;
        this.max = max;
        System.out.println("枚举构造-----");
    }
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}

class Test {
    public static void main(String[] args) {
        //Season s = Season.WINTER;

//        System.out.println(s.getMax());
//        System.out.println(s.getMin());

        //只要使用到枚举 :就会调用里面的 构造方法创建 枚举常量值.
        Season s0 = Season.WINTER;
    }
}
