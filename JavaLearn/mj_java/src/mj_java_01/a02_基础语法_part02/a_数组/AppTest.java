package mj_java_01.a02_基础语法_part02.a_数组;

import org.junit.Test;

public class AppTest {
    public static void main(String[] args) {


    }

    /**
     * 数组的创建:
     */
    public static void test01() {

        int[] array1 ;
        int[] arr2 = {} ; //定义个空数组

        int arr3[]= {} ; //也可以这样定义数组,不推荐❌

        //定义数组的时候 指定数组的长度
        int[] arr4 = new int[] {10, 20, 30};
        int[] arr5 = {10, 20, 30}; //省略 new int[] 是 语法糖形式

        //定义数组的时候 指定数组的长度
        int[] arr6 = new int[4]; //长度为4 的int 类型的数组
        arr6[0] = 1;
        arr6[1] = 2;
        arr6[2] = 3;
        arr6[3] = 4;

        //多维数组 三维数组
        int[][][] arr7;
        int[] arr8[][];

        /**
         * java中的  字符数组 != 字符串 ,   C语言是的
         */
        //字符数组
        char[] chars;
        //字符串
        String str ;

        /**
         * 推荐✅    使用: char[] chars 这种格式 是创建数组.
         * 不推荐❌: 使用
         */
        char[] chars1 = new char[] {'a','b','c'}; //✅
        char arr[] ; // ❌ 不推荐使用

    }

    /**
     * 02:Java 中的数组属于引用类型
     * 数组元素存储在堆空间 (heap)
     * Java 中的 堆内存申请会自动进行初始化
     *
     */
    public static void test02() {
        int[] array = {11, 22, 33};
        //如何分配内存请看 图解 : b_数组的内存.
    }

    /**
     * 数组的遍历:
     */
    @Test
    public void test03() {
        int[] arr = {11, 22, 33, 44};
        //for-i循环
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //第二种遍历:
        for (int element : arr) {
            System.out.println(element);
        }
        System.out.println(arr); //[I@1b9e1916 : [表示数组,I表示int类型,@后的是哈希值十六进制
        System.out.println(arr.hashCode());
        //[I@1b9e1916
        //463345942
        System.out.println(0x1b9e1916); //463345942  十进制形式打出来.
    }

}
