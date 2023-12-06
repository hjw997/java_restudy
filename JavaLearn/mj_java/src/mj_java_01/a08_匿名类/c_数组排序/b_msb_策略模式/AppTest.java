package mj_java_01.a08_匿名类.c_数组排序.b_msb_策略模式;


import java.util.Arrays;
import java.util.Comparator;

public class AppTest {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(10,4),new Cat(9,3),new Cat(11,5)};
        Sorter.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                if (cat1.weight < cat2.weight) return -1;
                else if (cat1.weight > cat2.weight) return 1;
                else return 0;
            }
        });
        System.out.println(Arrays.toString(cats));
    }
}
