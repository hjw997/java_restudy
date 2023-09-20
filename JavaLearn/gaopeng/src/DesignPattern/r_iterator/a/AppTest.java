package DesignPattern.r_iterator.a;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 该类演示 数组扩容
 */
public class AppTest {
    public static void main(String[] args) {
        int[] a = {11, 22, 33, 44, 55};
        System.out.println(Arrays.toString(a));

        //数组扩容 ：新分配空间把原来的拷贝过去。¡¡¡
        a = Arrays.copyOf(a,10);
        System.out.println(Arrays.toString(a));

    }
}
