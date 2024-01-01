package mj_java_01.a14_正则表达式.a_单字符匹配;

import org.junit.Test;

/**
 *
 */
public class AppTest {

    /**
     * 单字符匹配:[] 中括号
     */
    @Test
    public void test01() {
        //[abc] abc 当中的任意一个.
        // 等价与[a|b|c|] (a|b|c),小括号形式的时候()不能省略
        String regex0 = "[abc]at";
//        String regex0 = "(a|b|c)at";
        System.out.println("aat".matches(regex0));
        System.out.println("bat".matches(regex0));
        System.out.println("cat".matches(regex0));
        System.out.println("hat".matches(regex0));

    }

    @Test
    public void test02() {
        /**
         * 一般来说 ^ 表示一个字符串的开头，
         * 但它用在一个方括号的开头的时候，它表示这个字符集是否定的。
         * [^abc] 除 a,b,c 以外的任意字符.
         */
        String regex1 = "[^abc]at";
        System.out.println("cat".matches(regex1));
        System.out.println("bat".matches(regex1));
        System.out.println("hat".matches(regex1));
        System.out.println("fat".matches(regex1));

        System.out.println("-----------");
        //不是foo1~foo5 的 符合
        String regex2 = "foo[^1-5]";
        System.out.println("foo1".matches(regex2));
        System.out.println("foo5".matches(regex2));
        System.out.println("foo6".matches(regex2));

    }

    @Test
    public void test03() {
        /**
         * [a-zA-Z] : 表示从a-z,从A 到 Z 的任意字符
         */
        String regex1 = "[a-zA-Z]at";
        System.out.println("cat".matches(regex1));
        System.out.println("aat".matches(regex1));
        System.out.println("hat".matches(regex1));
        System.out.println("Bat".matches(regex1));

        //foo1~foo5
        String regex2 = "foo[1-5]";
        System.out.println("foo3".matches(regex2));
        System.out.println("foo6".matches(regex2));
    }

    /**
     * 并集:
     * [a-d[m-p]] : [a-dm-p] 并集(两部分加起来)  也就是[a,b,c,d,m,n,o,p] 的任意一个字符
     */
    @Test
    public void test04() {
        String regex = "[0-4[6-8]]"; //并集
        System.out.println("5".matches(regex));
        System.out.println("1".matches(regex));
        System.out.println("9".matches(regex));
    }

    /**
     * 交集:
     * [a-z&&[def]] a-z 和 def 的交集 d,e,f
     */
    @Test
    public void test05() {

        String regex = "[0-9&&[345]]";
        System.out.println("2".matches(regex));

        System.out.println("3".matches(regex));
        System.out.println("4".matches(regex));
        System.out.println("5".matches(regex));

        System.out.println("6".matches(regex));

    }

    /**
     * 差集:
     * [a-z&&[^bc] : 差集: 从[a-z] 中减去 [bc] 所以 [ad-z]
     */
    @Test
    public void test06() {

        String regex = "[0-9&&[^345]]";
        System.out.println("2".matches(regex));

        System.out.println("3".matches(regex));
        System.out.println("4".matches(regex));
        System.out.println("5".matches(regex));

        System.out.println("6".matches(regex));
    }

    /**
     * \w : 能组成单词的字符  (大小写字母,阿拉伯数字,下划线)
     * \\[123\\] 表示 要匹配 [123]
     * [123] 表示 匹配 1,2,3 中的任意字符.
     */
}
