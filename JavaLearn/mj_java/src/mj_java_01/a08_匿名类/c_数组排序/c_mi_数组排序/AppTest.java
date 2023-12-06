package mj_java_01.a08_匿名类.c_数组排序.c_mi_数组排序;

import mj_java_01.a08_匿名类.c_数组排序.a_msb_策略模式补充.Dog;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AppTest {
    public static void main(String[] args) {
        Integer[] array = {33, 22, 11, 77, 66, 99};
        System.out.println(Arrays.toString(array));
        //Arrays.sort(array) 默认是升序,如果要降序呢?
        //逻辑: Arrays.sort(array) 默认是升序,小的放左边, 大的放右边:
        Arrays.sort(array, new Comparator<Integer>() { //array 是什么类型的 这里就是什么类型的 泛型: Comparator<Integer>
            /**
             * 比较的原理是:遍历这个数组的时候,不断的去调用这个比较器,通过比较方法,决定数组元素怎么排.
             * 关于排序内容看 a包 和 b包 中 对 排序做了个回顾补充.(用了选择排序)当然后期mj数据结构算法第二季会做完整的补充.
             * 记得 里面 有两个 for 循环, 内部是循环一轮,外部是控制循环第几轮
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return 返回值说明
             * > 0 : o1 > o2
             * = 0 : o1 == o2
             * < 0 : o1 < o2
             * Arrays.sort(array)逻辑是 默认是升序( o1 - o2) , 小的放左边, 大的放右边
             * 现在如果要降序:那么就要 骗比较器左边的大,让其把大的放左边 o2 - o1
             */
            @Override
            public int compare(Integer o1, Integer o2) {

                // a negative integer(负数),   zero(零), or a positive integer (正数)
                //分别代表 as this object(o1) is less than(小于), equal to, or greater than the specified object(o2).
//                if (o1 < o2) return -1; // a negative integer(负数) 代表: this object(o1)  is less than the specified object(o2);
//                else if (o1 > o2) return 1; //this object(o1)  is greater than the specified object(o2);
//                else return 0;

                // Arrays.sort(array)逻辑是 默认是升序( o1 - o2) , 小的放左边, 大的放右边: 现在如果降序 我要骗一下比较器 99 比 77 小. 要放左边
                //return o1 - o2; //⬆️↗️⤴️升序 为什么升序??
                /***
                 * 只要返回值 是 > 0 , 排序器就认为是 o1 大于 o2  排序器的原本逻辑是: 小的放左边, 大的放右边 , 那么就会把 o1 放右边👉🏻
                 * 只要返回 是 < 0 排序器就认为是 o2 大于 o1 ,那么就会把 o2 大的 放右边 👉🏻
                 * 比如假设如下:
                 *    o1 : 99
                 *    o2 : 77
                 *    o1 - o2 = 99 - 77 返回正数 就会 认为 o1 大,会把o1大的 放右边
                 *    o1 99 就会被当到右边
                 * 如果下次:
                 *   o1 : 22
                 *   o2 : 77
                 *   o1 - o2 = 22 - 77 = -55 ,那么比较器 就认为 o2 大,会把 o2 放右边👉🏻
                 */


                return o2 - o1; // ⤵️↘️ 降序
                /**
                 * o1 : 99
                 * o2 : 77
                 * o2 - o1 = 77 - 99 = -22 ,小于0 ,那么就认为 o1 是比较大,会把 o1 往右放,即 99 77  降序排.
                 * 降序 就 要骗一下比较器 o2 大: 就会把 o2 77放到 右边. 这样就会是降序.
                 */

                /** 记住两点:✅✅✅
                 * 1.Arrays.sort(array)的 逻辑是 默认是升序 , 小的放左边, 大的放右边
                 * 2.那你怎么告诉他 谁大 谁小:
                 *  只要返回值 是 > 0 , 排序器就认为是 o1 大, 排序器的原本逻辑是: 小的放左边, 大的放右边 , 那么就会把 o1 放右边👉🏻
                 *  只要返回值 是 < 0 , 排序器就认为是 o2 大 ,那么就会把 o2 大的 放右边 👉🏻
                 *  o1 - o2 : 升序
                 *  o2 - o1 : 降序
                 */

            }
        });
        System.out.println(Arrays.toString(array));
    }
    public int compareTo(Dog o1,Dog o2) {
        //Returns:
        // a negative integer(负数),   zero(零), or a positive integer (正数)
        //分别代表 as this object(o1) is less than(小于), equal to, or greater than the specified object(o2).
        if (o1.food < o2.food) return -1; // a negative integer(负数) 代表: this object(o1)  is less than the specified object(o2);
        else if (o1.food > o2.food) return 1; //this object(o1)  is greater than the specified object(o2);
        else return 0;
    }
    /**
     @Override
     public int compareTo(Dog o) {
     //Returns:
     //               a negative integer(负数),   zero(零), or a positive integer (正数)
     //分别代表 as this object is less than(小于), equal to, or greater than the specified object.
     if (this.food < o.food) return -1; // a negative integer(负数) 代表: this object is less than the specified object;
     else if (this.food > o.food) return 1; //this object is greater than the specified object;
     else return 0;
     }
     */
    /**==================================================================*/

    /**
     * 1. 数组的打印:说明:
     * ✅推荐打印方式用 Arrays.toString
     *
     */
    @Test
    public void test01() {
        Integer[] array = {33, 22, 11, 77, 66, 99};

        //直接打印一个数组是:  [Ljava.lang.Integer;@6d6f6e28 因为数组是引用类型 哈希值的16进制
        System.out.println(array);
        //Arrays.toString :  会打成字符串格式:[33, 22, 11, 77, 66, 99]
        System.out.println(Arrays.toString(array)); /**✅ 推荐打印数组的方式: Arrays.toString 的方法 数组的字符串格式*/
        Arrays.sort(array); //默认是升序
        // 打印结果: [11, 22, 33, 66, 77, 99]
        System.out.println(Arrays.toString(array));
    }

}
