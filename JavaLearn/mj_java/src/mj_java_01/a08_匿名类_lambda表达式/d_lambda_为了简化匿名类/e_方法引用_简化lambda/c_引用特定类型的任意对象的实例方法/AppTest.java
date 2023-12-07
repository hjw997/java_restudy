package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.e_方法引用_简化lambda.c_引用特定类型的任意对象的实例方法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AppTest {

    public static void main(String[] args) {




    }

    @Test
    public void test01() {
        String[] strings = {"bbc", "abc", "bed", "adc"};
        Arrays.sort(strings); //默认升序 比较原理 : 一个一个字符ASCII码  对比谁大 排右边
        System.out.println(Arrays.toString(strings)); //[abc, adc, bbc, bed]
    }
    @Test
    public void test02() {
        String[] strings = {"bbc", "abc", "Bed", "Adc"};
        // Arrays.sort(strings); //默认升序 比较原理 : 一个一个字符对比谁大 排右边
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);  // 字符串有个默认比较大小的方法 compareTo: 其实上面的排序 就是这样的
            }
        });
        //lambda 简化
        Arrays.sort(strings,(s1,s2) -> s1.compareTo(s2));
        //ASCII 来说 大写字母的小 32 .
        System.out.println(Arrays.toString(strings));// [Adc, Bed, abc, bbc]

    }

    /**
     * 现在我希望我的排序是忽略大小写的
     */
    @Test
    public void test03() {
        String[] strings = {"bbc", "abc", "Bed", "Adc"};
        Arrays.sort(strings, new Comparator<String>() { //传入一个比较器:
            @Override
            public int compare(String o1, String o2) {
                //字符串本来有个 compareTo方法
                return o1.compareToIgnoreCase(o2);
            }
        });
        System.out.println(Arrays.toString(strings));// [abc, Adc, bbc, Bed]

        //简化 lambda :
        Arrays.sort(strings, (o1, o2) -> o1.compareToIgnoreCase(o2));

        /***
         * 如果lambda 表达式 中 只是调方法 ,那么就可以 使用方法引用:
         * 前两个例子 刚好是 lambda 参数和 里面调用的方法 参数对应 是 一个 或两个 能匹配
         * 但是:
         * (o1, o2) -> o1.compareToIgnoreCase(o2)
         * 方法调用和方法参数来自 lambda 的参数,
         * 以前是具体对象的方法
         * 现在是 o1 是任意对象,因为 o1 是来自 lambda 参数,是不确定的. 所以叫任意对象的方法:
         * ✅ : 引用特定类型的任意对象 的实例方法:
         *
         * String::compareToIgnoreCase 编译器会非常智能的 用第一参数调方法,第二个参数传入后面的方法中.
         * (o1, o2) -> o1.compareToIgnoreCase(o2)
         */
        Arrays.sort(strings, String::compareToIgnoreCase); //✅ : 引用特定类型的任意对象 的实例方法:


    }

}
