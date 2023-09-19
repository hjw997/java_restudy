package DesignPattern.m_decorator.e;


import java.io.*;
import java.nio.charset.StandardCharsets;

/***
 * 至此，我们已经学完了 "装饰器模式"
 *
 * 其实，我们前面学的 jdk 中的流，就是一种装饰器模式的体现。
 */
public class AppTest {
    public static void main(String[] args) throws IOException {
//        /// 字节流 ： 只能一个字节 一个字节的读取。就像嗑瓜子 ， 磕一个瓜子就跑去扔瓜子皮
//        InputStream in =  new FileInputStream("/Users/whj/Desktop/io_test/1.txt");
//
//        // 缓冲区 (嗑瓜子放烟灰缸）--也是字节流 ， 只是有了缓冲功能
//        BufferedInputStream fis = new BufferedInputStream(in);
//
//        //字节流 变为 字符流 需要码表（怎么编码，几个字节认定为一个字符）
//       InputStreamReader iReader = new InputStreamReader(fis, StandardCharsets.UTF_8);//字节变字符的桥梁
//
//       ///只需关闭最外层的码表。
//       iReader.close();

       char[] chars = "abcd".toCharArray();
        System.out.printf("----", chars);


    }
}
