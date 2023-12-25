package mj_java_01.a15_泛型_Generic.c_限制类型参数.b_限制类型参数_示例.b;

public class AppTest {

    public static void main(String[] args) {
        Double[] doubles = {5.6, 7.3, 8.8, 9.5};
        System.out.println(getMax(doubles));

        Integer[] integers = {9, 11, 8, 6, 13, 10};
        System.out.println(getMax(integers));

        /**
         * Integer  Double 等 实现了 Comparable 接口.
         */
    }


    /**
     * 针对 a 包中的问题
     * 解决方法:
     * 给 方法泛型 增加 类型参数的限制.
     * 所以现在也可以比较 实现了 Comparable 接口的类.
     */
    static <T extends Comparable<T>> T getMax(T[] array) {
        if (array == null || array.length == 0) return null;
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            // 获取最大值的逻辑:
//            if (array[i] > max) {
//                max = array[i]
//            }
            /**
                 public interface Comparable<T> {
                    public int compareTo(T o);
                 }
             int result = o1.compareTo(o2)
             result > 1  o1 大.
             result < 1  o2 大
             result == 0 o1 和 o2 相等.
             */
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }

            //✅ 也可以写为如下: 代码上少个 {} 简洁.
            if (array[i].compareTo(max) <=  0) continue;
            //<= 0 表示:max大.就不用交换.
            max = array[i];
        }
        return max;

    }

    /**
     * 现在 这个方法就支持了实现了 Comparable 的自定义类.比如 Person[] 中 比较那个人大.
     *  所以现在也可以比较 实现了 Comparable 接口的类. 看 c 包
     */
}
