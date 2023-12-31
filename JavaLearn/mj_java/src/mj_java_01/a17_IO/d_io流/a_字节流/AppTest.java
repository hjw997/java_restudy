package mj_java_01.a17_IO.d_io流.a_字节流;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 字节流: 一次只 读写 一个字节.
 * 输入流 InputStream,
 * 输出流 OutputStream
 *
 * 常用的字节流 Fileoutput
 */
public class AppTest {
    private static final String ioTestPath = "/Users/amos/Desktop/io_test/";
    public static void main(String[] args) throws IOException {

    }

    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fis = new FileInputStream(ioTestPath + "1.txt");
        /**
         * 读字节:
         */
//        int b1 = fis.read(); //读第一个字节
//        int b2 = fis.read(); //下一个
//        int b3 = fis.read(); //读到 码 的第一个字节.
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(b3);

        byte[] bytes = new byte[20];
        // 把读的字节内容放到 传入字节空间中,读数组大小.
        int len = fis.read(bytes); // 返回值 是 read方法的实际的字节长度.
        System.out.println(Arrays.toString(bytes));
        System.out.println(len);

        // 要把 20 个字节的长度 转化为 字符串.
        String str = new String(bytes); // 不指定解码 方式就是 默认的 UTF-8 .
        //使用 GBK编码   存入的时候 : 读出 : MJ���              
        //使用 UTF-8编码 存入的时候 : 读出 : MJ码哥            
        System.out.println(str);

        //把用真实有效的长度, 和 指定的编码 来解码 字符传.
        String str1 = new String(bytes, 0, len, StandardCharsets.UTF_8);
        //String str1 = new String(bytes, 0, len, "GBK");
        System.out.println(str1);

        //资源用完记得关
        fis.close();


    }

    /**
     * 01:字节输出流:FileOutputStream
     * @throws IOException
     */
    @Test
    public void testFileOutputStream() throws IOException {
//        File t1 = new File(ioTestPath + "1.txt");
//        if (!t1.exists()) t1.createNewFile();
        FileOutputStream fos = new FileOutputStream(ioTestPath + "1.txt" );
//        FileOutputStream fos = new FileOutputStream(ioTestPath + "1.txt" ,true); //文件 可追加
        //fos.write(65); //写一个字节进去
        //写字节数组进去 , 默认会覆盖原来的 . 想要追加 用 append 属性.
        fos.write("MJ码哥".getBytes(StandardCharsets.UTF_8));
//        fos.write("MJ码哥".getBytes(Charset.forName("GBK")));
        fos.close(); //用完记得关闭

        /**
         * 如果文件使用 UTF-8 编码, 那么解码要要用 UTF-8 来解码. 否则就会出现 乱码.
         * ✅: 从文件中读出来就是把 那些 二进制 读出来,然后通过 特定的几个字节表示一个字符的解码方式,解码出那些0101的二进制展示给人看的.
         */
    }
}
