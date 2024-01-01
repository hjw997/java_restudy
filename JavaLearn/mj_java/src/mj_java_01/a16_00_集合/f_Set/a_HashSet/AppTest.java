package mj_java_01.a16_00_集合.f_Set.a_HashSet;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class AppTest {
    public static void main(String[] args) {

    }


    /**
     * 1. HashSet
     */
    @Test
    public void test01() {
        /**
         * HashSet 实现了 Set<E> 接口.
         * 所以我们看 Set 有什么特点
         *
         * List 和 Set 特点:
         * List:
         * 可以存储重复的元素
         * 可以通过索引访问元素
         *
         * Set 的特点:
         * 不可以存储重复的元素 ( 去除重复的元素 )
         * 不可以通过索引访问元素.set 没有索引的概念.
         */

        Set<String> set = new HashSet<>();
        set.add("Jack");
        set.add("Rose");
        set.add("Kate");
        set.add("Jack");
        // Set不能通过索引来访问元素
        System.out.println(set); //无序的 :  [Kate, Rose, Jack] 会剔出到 重复的元素.✅
        /**
         * 顺序跟 Hash(主要的导向)  + 添加顺序 : 数据结构有详细介绍.
         */

        List<String> list = new ArrayList<>();
        list.add("Jack");
        list.add("Rose");
        list.add("Kate");
        list.add("Jack");
        System.out.println(list.get(1)); //Rose
        System.out.println(list); // 按照添加顺序 [Jack, Rose, Kate, Jack]

        String[] strings = {"A", "B", "C", "B"};
        Set<String> stringSet = new HashSet<>();
        for (String string : strings) {
            stringSet.add(string);
        }
        System.out.println(stringSet);

        // Set便利: 因为 都是实现了 Iterator 接口. 所有都已用迭代器
        for (String s : set) {
            System.out.println(s); //访问顺顺依然是乱序的
        }
        //上面的增强for循环语法就是下面的迭代器的语法糖 ✅: 是等价的.
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        // 也支持 forEach方法 方法内部就是迭代器遍历把元素传出来. 具体干什么 是 Consumer 接口的匿名对象.
        set.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 简化 lambda 当只有一条语句时候,可以省略 大括号,分号,return ,
        // 当只有一个参数时候可以省略小括号 , 但是没有参数时候,不能省略小括号.
        set.forEach(s -> System.out.println(s));

        // 当lambda 内部仅仅是一个方法的调用,那么可以使用方法引用.
        set.forEach(System.out::println); //方法引用.

    }

}
