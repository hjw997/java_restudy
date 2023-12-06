package mj_java_01.a08_匿名类_lambda表达式.c_数组排序.a_msb_策略模式补充;

import java.util.Arrays;


/**
 * 排序--推导 接口比较器 (策略模式)
 */
public class Sorter {

    public static  void sort(Cat[] arr) { //方法只能排序猫
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i; //记录最小位置的索引,假设刚开始是 0

            //控制执行一轮的 for循环.
            for (int j = i + 1; j < arr.length; j++) {
                //minPos = arr[j].compareTo() < arr[minPos] ? j : minPos;
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            //一轮循环完毕后 这个最小的索引 就 记录着最小的 索引值的位置.
            Cat temp = arr[i]; //取出最前面的 i = 0 时候就是最前面的
            arr[i] = arr[minPos]; //最小的 放到 "最前面"
            arr[minPos] = temp; //把原始最 前面的 放 换个位置.
        }
    }
    //如果对各种 动物 汽车 等等 排序. 则么搞? ✅ 希望大家遵守一个规则. (遵守协议-实现接口)
    //那就是 可比较的 来做比较 jdk 中的 comparable (可比较的)
    //所以任何对象想排序自己去实现 Comparable 接口.

    /**
     public interface Comparable<T> {
     * a negative integer, zero, or a positive integer
as this object is less than, equal to, or greater than the specified object.
           public int compareTo(T o);
      负数,0 , 正数 分别代表:小于 等于, 大于 这个比较的对象.
     }
     * @param arr
     */
    public static void sortCmp(Comparable[] arr) { //✅:更通用的比价方法.
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i; //记录最小位置的索引,假设刚开始是 0

            //控制执行一轮的 for循环.
            for (int j = i + 1; j < arr.length; j++) {
                //minPos = arr[j].compareTo() < arr[minPos] ? j : minPos;
                minPos = arr[j].compareTo(arr[minPos])  == -1 ? j : minPos;
//                if (arr[j]  < arr[minPos]) { // 如果发现有人比假设的 minPos 位置的数据还小 那么就记录这个还小的索引
//                    minPos = j; //记录下这个更小的索引.
//                }
            }
            //一轮循环完毕后 这个最小的索引 就 记录着最小的 索引值的位置.
            Comparable temp = arr[i]; //取出最前面的 i = 0 时候就是最前面的
            arr[i] = arr[minPos]; //最小的 放到 "最前面"
            arr[minPos] = temp; //把原始最 前面的 放 换个位置.
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i; //记录最小位置的索引,假设刚开始是 0

            //控制执行一轮的 for循环.
            for (int j = i + 1; j < arr.length; j++) {
                //minPos = arr[j] < arr[minPos] ? j : minPos;

                if (arr[j]  < arr[minPos]) { // 如果发现有人比假设的 minPos 位置的数据还小 那么就记录这个还小的索引
                    minPos = j; //记录下这个更小的索引.
                }

            }
            //一轮循环完毕后 这个最小的索引 就 记录着最小的 索引值的位置.
            System.out.println("找到 minPos:" + minPos);
            swap(arr,i,minPos); //把最小的往前面摆放
            System.out.println("经过第 " + i + "次循环之后,数组内容是:");
            System.out.println(Arrays.toString(arr));
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
