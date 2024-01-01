package mj_java_01.a14_正则表达式.b_预定义字符;

import org.junit.Test;

/**
 * 预定义字符 也叫 简写字符集
 * 正则表达式提供一些常用的字符集 简写
 * 提前定义好的字符所表示的含义.
 */
public class AppTest {
    /**
     * \w : 能组成单词的字符  (大小写字母,阿拉伯数字,下划线)
     */

    @Test
    public void test01() {
        /**
         简写:      简写的含义:
         .          任意字符
         \d         [0-9]数字
         \D         [^0-9](非数字)
         \s         等同于:  [ \t\n\f\r] (空白) 中的任意一个 ps 有空格 第一个是.
         \S         [^\s] (非空白)
         \w         [a-zA-Z_0-9]   能组成单词的字符  (大小写字母,阿拉伯数字,下划线)
         \W         [^\w] (非单词)

         ps:java中 以 1个 反斜杠(\)开头的字符会被当做转义字符处理.
         因此,为了在正则表达式中 完整地 表示预定义字符,需要以 2个 反斜杠开头,如"\d" 使用 "\\d"
         */

        //java中 以 1个 反斜杠(\)开头的字符会被当做转义字符处理.
        String regex = "\t"; //打印出来是转义为了 tab 符号
        System.out.println(regex + "1"); //打印看到前面有 tab键的空格.

    }

    @Test
    public void test02() {
        //. 代表任意字符
        String regex = ".";
        System.out.println("@".matches(regex));
        System.out.println("c".matches(regex));
        System.out.println("6".matches(regex));
    }

    @Test
    public void test03() {
        //如果就想代表 . 点
        String regex = "\\.";
        System.out.println("@".matches(regex));
        System.out.println("c".matches(regex));
        System.out.println("6".matches(regex));

        System.out.println(".".matches(regex));

        String regex1 = "\\.java";
        System.out.println(".java".matches(regex1));

    }

    @Test
    public void test04() {
        /**
         * \\[123\\] 表示 要匹配 [123]
         * [123] 表示 匹配 1,2,3 中的任意字符.
         */
        String regex = "\\[123\\]";
        System.out.println("1".matches(regex));
        System.out.println("2".matches(regex));
        System.out.println("3".matches(regex));
        System.out.println("[123]".matches(regex));
    }

    @Test
    public void test05() {
        /**
         * \d  表示任意数字
         *  ps:java中 以 1个 反斜杠(\)开头的字符会被当做转义字符处理.
         *  因此,为了在正则表达式中 完整地 表示预定义字符,需要以 2个 反斜杠开头,如"\d" 使用 "\\d"
         */
        String regex = "\\d";
        //String regex1 = "\d";  // 识别不了的转义字符 报错
        String regex2= "\t";     // 能识别的转义字符 tab 制表符

        System.out.println("c".matches(regex));
        System.out.println("9".matches(regex));

    }

    @Test
    public void test06() {
        /**
         \D   非数字  [^\d]
         */
        String regex = "\\D";
        System.out.println("c".matches(regex)); //
        System.out.println("9".matches(regex));

        String regex1 = " [^\\d] ";
        System.out.println("c".matches(regex));
        System.out.println("9".matches(regex));

    }

    @Test
    public void test07() {
        String regex = "\\w"; //a-zA-Z_0-9 大小写字母,数字,下划线
        System.out.println("b".matches(regex));
        System.out.println("_".matches(regex));
        System.out.println("8".matches(regex));
        System.out.println("+".matches(regex)); //false
    }

    @Test
    public void test08() {
        String regex = "\\W"; //非单词 [^\w]
        String regex1 = "[^\\w]"; //等价
        System.out.println("b".matches(regex));
        System.out.println("_".matches(regex));
        System.out.println("8".matches(regex));
        System.out.println("+".matches(regex)); //true
    }

    @Test
    public void test09() {
        /**
         \s  空白 [ \t\n\f\r] : 空格符 制表符(tab)
         */
        String regex = "\\s";
        System.out.println("\t".matches(regex));
        System.out.println(" ".matches(regex));
        System.out.println("\f".matches(regex));
        System.out.println("\n".matches(regex));
        System.out.println("\r".matches(regex));

        System.out.println("6".matches(regex));

    }

    @Test
    public void test10() {
        //非空白(不是空白)  \S  [^\s] 不是 [ \t\n\f\r]
        //\f 换页
        String regex = "\\S";
        System.out.println("\t".matches(regex));
        System.out.println(" ".matches(regex));
        System.out.println("\f".matches(regex));
        System.out.println("\n".matches(regex));
        System.out.println("\r".matches(regex));

        System.out.println("6".matches(regex)); //true
    }


}
