package mj_java_01.a08_匿名类_lambda表达式.c_数组排序.a_msb_策略模式补充;

import java.util.Arrays;

/**
 * 选择排序:
 */
public class SelectionSorter {
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

    public static void main(String[] args) {
        int[] array = {2,6,3,1,8,0,9};
        System.out.println(Arrays.toString(array));
        SelectionSorter.sort(array);
        System.out.println("-----------最终结果------------");
        System.out.println(Arrays.toString(array));

    }
}
