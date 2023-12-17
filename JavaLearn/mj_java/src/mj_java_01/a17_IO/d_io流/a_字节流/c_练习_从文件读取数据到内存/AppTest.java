package mj_java_01.a17_IO.d_io流.a_字节流.c_练习_从文件读取数据到内存;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AppTest {
    private static final String ioTestPath = "/Users/whj/Desktop/io_test/";

    public static void main(String[] args) {
        /**
         * 任何文件中的内容都是 二进制的 0101010 的数据. 如果仅仅是读取字节数组 是不用 解码的.
         * 如果直接读到内存中 是 字节数组.
         */
        byte[] bytes = Files.read(new File(ioTestPath + "2.txt"));
        System.out.println(Arrays.toString(bytes));

        /**
         * 只有在 把 字节转为 字符 , 或者 字符 转为 字节 的时候才考虑编码方式 问题.
         */
        //看这个字节是什么,需要解码 , 必须知道当初是什么方式 编码存进文件的.
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
