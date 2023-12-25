package mj_java_01.a15_泛型_Generic.c_限制类型参数.b_限制类型参数_示例.a;

/**
 * 获取 数组中的最大值
 */
public class AppTest {
    public static void main(String[] args) {
        //https://www.bilibili.com/video/BV1F44y1r7cv?p=57&spm_id_from=pageDriver&vd_source=9d2ff4daa93ba2f65d04081137bf4e05

        Double[] doubles = {5.6, 7.3, 8.8, 9.5};
        System.out.println(getMax(doubles));

        Integer[] integers = {9, 11, 8, 6, 13, 10};
        System.out.println(getMax(integers));

    }

    public static <T> T getMax(T[] array) {
        //如果空数组 返回 null
        if (array == null || array.length == 0) return null;
        T max = array[0];//假设 最大的是 第一个元素 ,

        for (int i = 1; i < array.length; i++) { //从1 开始遍历就行. 从0 也不会有问题.
            // 扫描一遍看  如果出现 比 假设的 max 大 那就是真的最大交换.
//            if (array[i] > max) { //❌:如果直接比较 是 报错的 因为泛型 有可能不支持比较大小.
//                max = array[i];
//            }
        }
        return max;
    }
    /**
     * 看 b 包解决问题
     */
}
