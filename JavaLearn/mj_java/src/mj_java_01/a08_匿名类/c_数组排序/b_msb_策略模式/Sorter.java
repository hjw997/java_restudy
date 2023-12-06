package mj_java_01.a08_匿名类.c_数组排序.b_msb_策略模式;

import mj_java_01.a08_匿名类.c_数组排序.a_msb_策略模式补充.Cat;

import java.util.Arrays;
import java.util.Comparator;


/**
 *
 * 现在有个问题就是 : 这个 猫和狗的 比较方法是 写死的.
 * 我们如果 改个比较的规则:
 * 此时 就要修改 猫 和 狗 这俩类里面的 compareTo 里面的方法实现,
 * 这样如果每次 换一个比较方法都要来改 代码.---这就违反了开闭原则.
 *
 * 有没有一种方法 把要比较的 代码传入进来呢? 传入一个比较器Comparator
 *
 * 通用的排序 进化 :
 * 使用比较器 传入不同的比较策略
 */
public class Sorter {
    public  static <T> void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i; //记录最小位置的索引,假设刚开始是 0

            //控制执行一轮的 for循环.
            for (int j = i + 1; j < arr.length; j++) {
                //minPos = arr[j].compareTo() < arr[minPos] ? j : minPos;
                /**如果使用 实现了 compareTo 的方法就比较死板,对象的 可比较方法是固定的,现在使用一个比较器 由外部来决定比较方法更灵活.  */
                //minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
                minPos = comparator.compare(arr[j],arr[minPos]) == -1 ? j : minPos;

            }
            //一轮循环完毕后 这个最小的索引 就 记录着最小的 索引值的位置.
//            T temp = arr[i]; //取出最前面的 i = 0 时候就是最前面的
//            arr[i] = arr[minPos]; //最小的 放到 "最前面"
//            arr[minPos] = temp; //把原始最 前面的 放 换个位置.

            swap(arr,i,minPos);
        }
    }

    private static <T>void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
