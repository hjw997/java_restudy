package mj_java_01.a17_IO.d_io流.c_字符流.a_字符流;

import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 字符流 特点:
 * 一次只读写一个字符.
 * 最终都继承自 Reader Writer
 *
 * 常用的字符流 有 FileReader FileWriter  把字节当成字符读进来.
 *
 * PS:注意这两个类 只适合 文本文件(字符集编码的文件)  ,比如 .txt  , .java 等这类文件
 *
 */
public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;

    private File  file = new File(ioTestPath + "mj2.text");
    public static void main(String[] args) {


    }

    @Test
    public void test00() {
        /**
         * 文本文件 可否使用 字节流读呢 ?可以 把字节 读取 再用编码 转为 字符
         */
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            System.out.println(bytes.length); //字节数组的长度  8 个 字节.
            String content = new String(bytes, Charset.defaultCharset());
            System.out.println("mj2.text content is: " + content);
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

    /**
     * 读一个字符
     * 字符流 : PS 只适合 文本文件.
     * 字节流 是万能的,可以读任何文件. 因为任何类型的文件 存储在磁盘都是 010101 的字节数据.
     */
    @Test
    public void test01() {

        try(Reader reader = new FileReader(file)){

            /**
             * FileReader 读的原理:
             * 比如一个有个文件里面的字节:[77,74,-20,-90,-89,-45]
             * 每次调用 read 读一个字符进来. 是按照一定的编码 把对应个字节转为一个字符.
             * 假如 utf-8 编码 : 77 单字节 74 ,单字节, 后面 就是 3 个字节一个字符
             * 假如 gbk 编码 :  77 单字节 74单字节, 后面 2个字节编码为一个汉字字符.
             * 所以 一个字符 几个字节 看编码方式.
             */

            int r1 = reader.read(); // 返回值就是个字符.->单字节 读一个字节然后编码
            System.out.print(r1);
            System.out.println((char) r1); //想要看字符的内容 就强转一下.

            int r2 = reader.read(); // ->单字节 读一个字节然后编码 为一个字符
            System.out.print(r2);
            System.out.println((char) r2);

            /**
             * 遇到汉字:
             * -> 如果GBK   双字节 读2个字节然后编码为一个字符
             * -> 如果UTF-8 三个字节 ,读 3个字节 然后编码为一个字符.
             * 后面的汉字以此类推.
             */
            int r3 = reader.read();
            System.out.print(r3);
            System.out.println((char) r3);

            int r4 = reader.read();
            System.out.print(r4);
            System.out.println((char) r4);

            int r5 = reader.read();
            System.out.print(r5);
            System.out.println(r5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1_0() {

        try (Reader reader = new FileReader(file)) {

            //⚠️ 注意此时的这里是 字符数组:
            char[] chars = new char[1024];
            // reader.read 返回值是 实际读的字符长度.
            int len = reader.read(chars);
            /**
             *  reader.read 是将读的内容 填充到字符数组中,
             *  如果文件没有 字符数组长度那么大,
             *  就只有文件内容的长度.所以要返回 实际读的字符的长度.
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileWrite 写字符 到文件.
     */
    @Test
    public void test02() {
        //try-with-resource 会自动 进行关闭.
        try (Writer writer = new FileWriter(ioTestPath + "mj.txt") ) {
            //一个字符一个字符写
            writer.write('M');
            writer.write('J');
            writer.write('码');
            writer.close(); //会自动 进行关闭.✅
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        try ( Writer writer = new FileWriter(ioTestPath + "mj2.text") ) {
            writer.write("MJ");
            /**
             * 将字符串转为了字符数组.
             * 查看内部的源代码:
             *      可以看出将字符串转为了 字符数组
             */
            char[] chars = "码哥".toCharArray(); //字符数组
            writer.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
