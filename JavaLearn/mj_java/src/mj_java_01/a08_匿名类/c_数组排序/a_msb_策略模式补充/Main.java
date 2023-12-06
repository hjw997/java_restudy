package mj_java_01.a08_匿名类.c_数组排序.a_msb_策略模式补充;

import java.util.Arrays;

/**
 * 测试代码:
 */
public class Main {

    public static void main(String[] args) {
        // sortCatTest_02();
        sortDogTest_03();
    }

    public static void sortDogTest_03() {
        Dog[] dogs = {new Dog(10),new Dog(9),new Dog(11)};
        Sorter.sortCmp(dogs);
        System.out.println(Arrays.toString(dogs));
        /**
         [Dog{food=9}, Dog{food=10}, Dog{food=11}]
         */
    }

    public static void sortCatTest_02() {
        Cat[] cats = {new Cat(10,4),new Cat(9,3),new Cat(11,5)};
        Sorter.sort(cats);
        System.out.println(Arrays.toString(cats));
        /**
         [Cat{weight=9, height=3}, Cat{weight=10, height=4}, Cat{weight=11, height=5}]
         */
    }

    //整数排序测试.
    public static void sortTestInt_01() {
        int[] array = {2,6,3,1,8,0,9};
        System.out.println(Arrays.toString(array));
        Sorter.sort(array);
        System.out.println("-----------最终结果------------");
        System.out.println(Arrays.toString(array));
    }
}
