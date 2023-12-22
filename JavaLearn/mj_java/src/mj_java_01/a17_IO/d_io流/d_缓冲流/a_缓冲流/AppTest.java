package mj_java_01.a17_IO.d_io流.d_缓冲流.a_缓冲流;


import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 *
 * 本地输入API : 操作系统底层API 就是操作磁盘.
 * 无缓冲的 字节流 的 read write 读写的每个字节都会访问磁盘.
 * 有缓冲的流,就在内存中有个缓冲区,每次读都会先从磁盘读取一大段(默认8192 8kb) 预读到缓冲区.
 *          然后每次的 read 先从 缓冲区读.一只读到缓冲区没有内容了,又会取磁盘读一大段数据到缓冲区.
 *          write 也是一样的,每次 write 先写入 输出的缓冲区, 缓冲区满了才会写入磁盘.
 *
 * 缓冲流作用:减少磁盘的访问次数,提高读写效率 .
 * 缓冲流有:
 *      缓冲字节流   缓冲字符流
 *          |          |
 *       输入/输出   输入/输出
 *  以上4个缓冲流默认缓冲区大小是 8192 字节(8KB) ,可通过构造方法传参设置缓冲区大小.
 *
 *  缓冲流使用方法:
 *  将无缓冲的流,传递给缓冲流的构造方法,将无缓冲的流包装为缓冲流.
 */
public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;

    public static void main(String[] args) throws IOException {
        File file = new File(ioTestPath + "write.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("abc111");
        /**
         * write.newLine()
         * 断点调试可见里面的 lineSeparator 是 \n
         * 回车 换行: \r\n
         */
        writer.newLine();
        writer.close();


        /**
         * 缓冲流细节: close() 的时候 内部会 调用一次 flush方法,把缓冲区的内容写到文件.
         */

    }

    @Test
    public void test00() {

    }


    /**
     * 测试 缓冲流 写入
     */
    @Test
    public void testBufferWrite() {
        byte[] data = "我是java学习者".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(data));
        Files.writeWithBuffer(data,new File(ioTestPath + "utf_8.txt"));
    }
}
