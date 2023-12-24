package mj_java_01.a16_集合.b_ArrayList.a_ArrayList常见操作使用;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class AppTest {

    /**
     * 1.数组的缺点 :
     * 不能动态扩容, 创建的时候就要指定大小.
     * 不够面向对象 不能 xx.add()
     */
    @Test
    public void test01() {
        //一旦申请了 堆空间 ,数组大小就不能再扩大了.
        int[] array = new int[4];

        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        //再添加一个 还要自己看 索引已经到哪里了. 不够面向对象.
        array[3] = 4;
    }

    /**
     * 2. ArrayList 基本使用:
     */
    @Test
    public void test02() {
        //不用泛型 什么都可以加
    }

    /**
     * 3.ArrayList常用方法:
     */
    @Test
    public void test03() {

    }

    /**
     * 4.retainAll
     *   retain:保留
     */
    @Test
    public void test04() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(22);
        list1.add(33);
        list1.add(44);

        List<Integer> list2 = new ArrayList<>();
        list2.add(33);
        list2.add(44);

        // 从list1 中 删除掉 list2 中元素以外 的所有元素. 即:保留和list2中一样的元素.
        list1.retainAll(list2); //[33, 44]
        System.out.println(list1);
    }


    /**
     * 补充 数组对象不可以 类型转换
     */
    @Test
    public void test05_0() {

        Object[] objects = {1, 2, 3};
        for (Object object : objects) {
            System.out.println(object.getClass());
        }
        /**
         * class java.lang.Integer
         * class java.lang.Integer
         * class java.lang.Integer
         */

        //既然都是 Integer 那么可否 如下 类型转换: ❌ java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        Integer[] integers = (Integer[]) objects; // 对象数组 是不能类型转换的 .

        //为什么 不能转换:
        Object[] objects1 = {1, 2, 3}; //乍一看 可以转为 Integer[] 其实不行.
        //本质是如下: new Object 数组. 里面放 1, 2,3
        Object[] objects2 = new Object[] { 1 ,2 , 3 };

        //Object[] 数组类型 转为 Integer[] 肯定不行. 错误❌

        Object obj1 = new Object();
        //父类 不能强制类型转为 子类.
        Integer obj2 = (Integer) obj1; //❌ java.lang.ClassCastException: java.lang.Object cannot be cast to java.lang.Integer

    }

    /**
     * 5.ArrayList toArray :动态数组 转为 普通数组
     */
    @Test
    public void test05() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);


        /**
         * PS : 这个方法 Object[] toArray();
         * 返回的是 Object[]  那么我想要的 是 Integer[] 这种数组. 不可以强制转换_补充内容如上的测试方法.
         */
        Object[] objects = list.toArray(); //看似 objects 中是 Integer类型的 不要误以为 可以 转为 Integer[] 类型的.
        //Integer[] integers = (Integer[]) objects; // ❌ java.lang.ClassCastException

        /**
         * 那我现在想要 Integer[] 这种数组 怎么办?
         */
        // <T> T[] toArray(T[] a); 泛型方法.
        Integer[] integers = list.toArray(new Integer[0]); //✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅
        /**
         * ✅✅: new Integer[0] 给一个空数组, 这里这个只是起到 过渡作用. 告诉编译器 返回类型是 Integer[0] , 不占空间.
         * 妙啊 ✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅
         */
        System.out.println(integers); //[Ljava.lang.Integer;@1b9e1916 确实是 Integer 类型的数组.
        System.out.println(Arrays.toString(integers));

        System.out.println(list);//[11, 22, 33] 为何 list 就能打印出这种 Arrays.toString效果?
        /**
         * 内部 父类实现了 toString的 方法.
         */

    }

    @Test
    public void test06() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        /**
         * 方法1: for-i 有索引 经典遍历 好处有索引
         */
        //for (int i = 0; i < list.size(); i++) {
        int size = list.size(); //建议抽出来提高代码效率
        for (int i = 0; i < size; i++) {
             Integer element = list.get(i);
            System.out.println(element);
        }

        /**
         * 2.使用迭代器-迭代器设计模式.
         * 也是迭代器的使用方法.
         */
        Iterator<Integer> iterator = list.iterator();
        //迭代器原理:
        while (iterator.hasNext()) {
            //next() 是取一个元素 . 两件事:1.取出游标所指元素,2.游标向下挪动一个位置.
            //hasNext() 有没有下一个 :就是判断 cursor游标 有没有 到尾部(size) .
            Integer element = iterator.next();
            System.out.println(element);
        }

        /**
         * 3.for-each 格式: ✅
         */
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("============");

        list.forEach(new Consumer<Integer>() {
            //每次拿到一个元素 就调用 accept方法把元素传过来.
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //lambda 表达式
        list.forEach(integer -> {
            System.out.println(integer);
        });
        //只有一行继续简化:
        list.forEach(integer -> System.out.println(integer));

        //方法引用: lambda 中 如果只是 唯一的一句在调用方法:考虑方法引用
        list.forEach(System.out::println);

    }

    /**
     * 遍历的注意点.
     *  for (元素类型 e: 数组\Iterable) 可以放的
     */
    @Test
    public void test07() {
        /**
         for (元素类型 e: 数组\Iterable) {

         }
         */

        //1.数组可用 for-each
        String[] args = new String[5];
        for (String s : args) {
            System.out.println(s);
        }

        //2.Iterable
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        //因为  Collection<E> extends Iterable .实现了Iterable 接口.
        // 集合框架预览图可以看出只有Map没有实现Iterable接口.
        for (Integer integer : list) {
            System.out.println(integer);
        }

        /**
         * 本质是迭代器. 编译器底层就是使用了迭代器 于生成 hasNext 这样的形式.
         *  for (Integer integer : list) 这种只是迭代器的语法糖.✅
         */

    }


}
