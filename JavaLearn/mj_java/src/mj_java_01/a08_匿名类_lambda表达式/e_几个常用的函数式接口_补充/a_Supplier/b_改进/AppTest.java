package mj_java_01.a08_匿名类_lambda表达式.e_几个常用的函数式接口_补充.a_Supplier.b_改进;

import org.junit.Test;

import java.util.function.Supplier;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 从两个字符串中获取一个不为空的字符串
         */
    }

    @Test
    public void test01() {

        //makeString() 要先调用 , 然后传入函数
        String res = getFirstNotEmptyString1("abc", makeString());
        System.out.println(res);

        //传入一个匿名对象,没有直接调用 makeString()一上来就去获取.
        String result = getFirstNotEmptyString2("abc", new Supplier<String>() {
            @Override
            public String get() {
               return makeString();
            }
        });
        // 函数是接口可以使用 lambda 简化: ✅ 就是可以节省开销了. 延迟调用 makeString
        getFirstNotEmptyString2("abc", () -> makeString());

        // lambda 中如果仅仅是一个方法调用 就可以用方法引用.
        getFirstNotEmptyString2("abc", AppTest::makeString);
        System.out.println(result);
    }

    static String getFirstNotEmptyString1(String s1, String s2) {
        if (s1 != null && s1.length() != 0) return s1;
        if (s2 != null && s2.length() != 0) return s2;
        return null;
    }

    static String getFirstNotEmptyString2(String s1, Supplier<String> s2Supplier) {
        if (s1 != null && s1.length() > 0) return s1;

        //有必要的时候 调用:
        String s2 = s2Supplier.get();
        if (s2 != null && s2.length() > 0) return s2;

        return null;
    }

    static String makeString() {
        //假设这个方法里构建字符串 比较复杂耗时
        return String.format("%d %d", 1, 2);
    }

    /**
     * 针对 a 包中问题 做个优化:
     * 如果 能获取到第一个 不为空的 值,后面的代码就不要执行了.

     */

    /** Supplier 接口
         @FunctionalInterface
         public interface Supplier<T> {
           T get();
         }
     */

}
