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
 * 常用的字符流 有 FileReader FileWriter
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
         * 文本文件 可否使用 字节流读呢 ?可以 把字节 读如 再用编码 转为 字符
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
     */
    @Test
    public void test01() {
        try(Reader reader = new FileReader(file)){
            int r1 = reader.read();
            System.out.print(r1);
            System.out.println((char) r1);

            int r2 = reader.read();
            System.out.print(r2);
            System.out.println((char) r2);

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
            char[] chars = "码哥".toCharArray(); //字符数组
            writer.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
