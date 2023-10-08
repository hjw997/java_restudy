package DesignPattern.a_single_responsibility.negative;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

public class AppTest {
    public static void main(String[] args) throws Exception{
        //统计一个文件中有多少个单词. 字符流要查码表.

        String filePath = "/Users/whj/Desktop/io_test/1.txt";

        System.out.println(Charset.defaultCharset()); //默认是 : UTF-8
        /**
         * 一个汉字占几个字节? 那么就要看码表了.
         * GBK 码表一个汉字占 2个字节,且汉字的两个字节,都是以1开头. 汉字的编码规则: 所以读取的时候发现开头是1 就连着读2个字节 作为一个汉字.
         * UTF-8 一个汉字 占3个字节.
         *
         */

        Reader in = new FileReader(filePath, Charset.defaultCharset());
        //Read 默认查询的 是 和 操作系统一致的编码.
        int read = in.read();
        System.out.println(read);
        read = in.read();
        System.out.println(read);
//        while ((read = in.read()) != -1) {
//            System.out.println(read);
//        }
        in.close();
        System.out.println("---------");
        /**
         * 字节流 读的时候不会管你开头是 1 还是啥. 因为 只关心一个一个的字节. 不用编码.
         */
        InputStream is = new FileInputStream(filePath);

        System.out.println(is.read());
        System.out.println(is.read());
        System.out.println(is.read());
        System.out.println(is.read());
        is.close();


    }
}
