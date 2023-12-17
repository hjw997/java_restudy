package mj_java_01.a17_IO.b_字符集_字符编码;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        /**
         *
         * 字符:
         * 字符(Character)指人类使用的文字或符号的总称，包括文字符号、图形符号、数学符号、字母、运算符号、标点符号和其他符号，
         * 以及一些功能性符号。可以由一个或多个字节表示。
         * 一般来说我们称某个字符集里面的字符，叫xx字符，如ASCII字符集里面的ASCII字符，GB2312字符集里面的GB2312字符。
         *
         *
         * 字符集 Charset
         *
         * 字符集(Character Set、Charset)，一组由字符组合的集合。
         * 每个字符在一个字符集中都有一个唯一的编码值（码点）。
         * 字符集常常和一种具体的语言文字对应起来，该文字中的所有字符或者大部分常用字符就构成了该文字的字符集，比如英文字符集。
         * 一组有共同特征的字符也可以组成字符集，比如繁体汉字字符集、日文汉字字符集。 字符集的子集也是字符集。
         * 字符集通常用来框定一个范围。包含这些字符就已经够了，可以满足日常使用了。
         *
         * 常见字符集：
         * ASCII字符集 : 128 个字符(包含因为字母大小写,阿拉伯数字等)
         * GB2312字符集、
         * BIG5字符集、
         * GBK字符集、
         * GB18030字符集、
         * Unicode字符集:包括了世界上所以字符.
         *
         * 常见 字符集: 看课件 a 和 b .
         *
         *
         * 不同的字符集 编码方式不一样.
         * 每个字符集都有对应的字符编码,它(字符编码) 决定了每个字符如何转为二进制存储在计算机中.
         * ASCII : 单字节, 每个字符用一个字节. ASCII 总共 128个 就表达完了 所以编码法范围 0x00-0x7F (0-127)
         *
         * Unicode指Unicode字符集。
         * Unicode的编码有多种实现方式，譬如UTF-8编码、UTF-16编码、UTF-32编码等
         */

        String name = "你好123"; //在内存/硬盘等 就是二进制的 0101010 . 转成二进制是啥样呢?
        /**
         * 如果使用的是不同的字符集, 那么转成二进制后也是不同的.
         */
        String str = "AaMJ码哥";
        // [65, 97, 77, 74, 63, 63] ASCII字符集中没有汉字, 不认识的就是63
        byte[] asciiBytes = str.getBytes(StandardCharsets.US_ASCII);

        // [65, 97, 77, 74, 63, 63] 不认识的就是63
        byte[] iso8859_1Bytes = str.getBytes(StandardCharsets.ISO_8859_1);

        // [65, 97, 77, 74, -62, -21, -72, -25]
        byte[] GB2312Bytes = str.getBytes(Charset.forName("GB2312"));

        // [65, 97, 77, 74, 63, -83, -12] //不认识简体中文.
        byte[] BIG5Bytes = str.getBytes(Charset.forName("BIG5"));

        // [65, 97, 77, 74, -62, -21, -72, -25]
        byte[] gbkBytes = str.getBytes(Charset.forName("GBK"));

        // [65, 97, 77, 74, -62, -21, -72, -25]
        byte[] GB18030Bytes = str.getBytes(Charset.forName("GB18030"));

        // [65, 97, 77, 74, -25, -96, -127, -27, -109, -91] 三个字节来表达汉字,
        byte[] utf_8Bytes = str.getBytes(StandardCharsets.UTF_8);
        /**
         * 所以比如 "AaMJ码哥" 字符串存到 硬盘文件 就可以看出不同的 字符集编码 在文件中的 字节也是不一样的.
         */

        //只要是来自ASCII字符集中的都是 单个字节.
        /**
         * 每个字符集都有对应的字符编码,它(字符编码) 决定了每个字符如何转为二进制存储在计算机中.
         * 如果使用的是不同的字符集, 那么转成二进制后也是不同的
         * String str = "AaMJ码哥"; 不同的字符集 转成二进制如下:
         * [65, 97, 77, 74, 63, 63]
         * [65, 97, 77, 74, 63, 63]
         * [65, 97, 77, 74, -62, -21, -72, -25]
         * [65, 97, 77, 74, 63, -83, -12]
         * [65, 97, 77, 74, -62, -21, -72, -25]
         * [65, 97, 77, 74, -62, -21, -72, -25]
         * [65, 97, 77, 74, -25, -96, -127, -27, -109, -91]
         */
        System.out.println(Arrays.toString(asciiBytes));
        System.out.println(Arrays.toString(iso8859_1Bytes));
        System.out.println(Arrays.toString(GB2312Bytes));
        System.out.println(Arrays.toString(BIG5Bytes));
        System.out.println(Arrays.toString(gbkBytes));
        System.out.println(Arrays.toString(GB18030Bytes));
        System.out.println(Arrays.toString(utf_8Bytes));

        //获取默认的字符集 : 跟随 JVM默认字符编码, JVM默认字符编码 又跟随 main方法 所在文件的字符编码.
        System.out.println(Charset.defaultCharset());
    }

    @Test
    public void test01() {
        String str = "MJ码哥";
        try {
            byte[] gbks = str.getBytes("UTF-8");
            System.out.println(Arrays.toString(gbks));

            for (byte gbk : gbks) {
                System.out.format("%d = %s hex=%s \n",gbk, Integer.toString(gbk, 2),Integer.toString(gbk, 16));
                //System.out.format("" , Integer.toBinaryString(gbk));

            }


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


    }
}
