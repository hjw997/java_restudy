package mj_java_01.a08_匿名类_lambda表达式.e_几个常用的函数式接口_补充.a_Supplier.a_问题;

import org.junit.Test;

public class AppTest {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        String result = getFirstNotEmptyString("abc", makeString());
        System.out.println(result);
    }

    /**
     * 从两个字符串中获取一个不为空的字符串
     * @param s1
     * @param s2
     * @return
     */
    static String getFirstNotEmptyString(String s1, String s2) {
        if (s1 != null && s1.length() != 0) return s1;
        if (s2 != null && s2.length() != 0) return s2;
        return null;
    }
    static String makeString() {
        //假设这个方法里构建字符串 比较复杂耗时
        System.out.println("调用--makeString()方法");
        return String.format("%d %d", 1, 2);
    }

    /**
     * 现在 a 包中问题是 :
     * 如果getFirstNotEmptyString 方法 已经获取到了 第一个值 ,
     * 然后 makeString() 还是会执行的. 造成 运算上的浪费.
     */

}
