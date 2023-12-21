package mj_java_01.a17_IO.d_io流.d_缓冲流.c_缓冲流补充;


import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;

/**
 * 补充: 更进一步 感受 缓冲流:
 */
public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;

    public static void main(String[] args) {

    }

    @Test
    public void test01() throws IOException {
        File testFile = new File(ioTestPath + "test1.txt");
        FileOutputStream fos = new FileOutputStream(testFile);
        /**
         * 断点 感受下 一个字节一个字节写入 .
         * 字节流 每写一次 文件内容就发生变化了,说明确实 是每次 write 都是 对 磁盘写入:
         */
        fos.write(97); //此时文本中是 a
        fos.write(98); //写完后 变为 ab
        fos.close();
    }

    @Test
    public void test02() throws IOException {
        File testFile = new File(ioTestPath + "test2.txt");
        FileOutputStream fos = new FileOutputStream(testFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        /**
         * 断点 感受下 缓冲流写入, 直到 有 flush 后 内存缓冲区的 才会 写入磁盘.
         */
        bos.write(97);
        bos.write(98);
        bos.flush();
        fos.close();

        /**
         * FileWriter : 认知中看似没缓冲.
         * public class StreamEncoder extends Writer {
         *     private static final int DEFAULT_BYTE_BUFFER_SIZE = 8192;
         *     ...
         */
        FileWriter writer = new FileWriter(testFile); //无缓存吗? 内部是有缓存的
        writer.write('a'); //没有立马看到 文件中写入内容.
        writer.write('b'); //没有立马看到 文件中写入内容.
        writer.close();
    }


}
