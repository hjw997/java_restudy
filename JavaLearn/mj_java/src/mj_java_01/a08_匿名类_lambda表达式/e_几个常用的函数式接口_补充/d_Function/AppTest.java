package mj_java_01.a08_匿名类_lambda表达式.e_几个常用的函数式接口_补充.d_Function;

import org.junit.Test;

import java.util.function.Function;

public class AppTest {
    public static void main(String[] args) {
    }

    /**
     * Function - andThen:
     */
    @Test
    public void test02() {
        String[] strings = {"123", "34", "44"};
        //整个下来就是 求 这些字符串数组中的 个位数 的和
        int sum1 = sum(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        }, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer % 10; //求个位数 .
            }
        });
        System.out.println(sum1);
    }

    @Test
    public void test01() {
        String[] strings = {"123", "34", "44"};

        int sum = sum(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
        //lambda 简化
        int sum2 = sum(strings, s -> Integer.valueOf(s));

        //方法引用:如果lambda 内部只是一个方法调用 那么可以使用方法引用
        int num3 =  sum(strings,  Integer::valueOf);
        System.out.println(sum);
    }

    /**
     *
     * @param strings
     * @param f 外面决定字符串怎么转整数 .
     * @return
     */
    static int sum(String[] strings, Function<String, Integer> f) {
        if (strings == null || f == null ) return 0;
        int sum = 0;
        for (String string : strings) {
            // R apply(T t); //把字符串 传出去, 外面决定转换方案.
            sum += f.apply(string);
        }
        return sum;
    }

    static int sum(String[] strs, Function<String, Integer> f1, Function<Integer, Integer> f2) {
        if (strs == null || f1 == null || f1 == null) return 0;
        int result = 0;
        for (String str : strs) {
            //str 先经历 f1 转换后得到一个值,然后这个值再经历 f2 转换
            result += f1.andThen(f2).apply(str);
        }
        return result;
    }

    static int sum2(String[] strs, Function<String, Integer> f1, Function<Integer, Integer> f2) {
        if (strs == null || f1 == null || f1 == null) return 0;
        int result = 0;
        for (String str : strs) {
            // compose 是 str先经历 f1得出一个结果,  再经历 f2 得出一个结果.
            // 刚好和 andThen 反过来的.
            result += f2.compose(f1).apply(str);
        }
        return result;
    }



}
