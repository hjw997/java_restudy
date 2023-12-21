package mj_java_01.a17_IO.d_io流.d_缓冲流.a_缓冲流;


import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 缓冲流作用:就是拿来提高效率的.
 */
public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;

    public static void main(String[] args) {

        /**
         * write.newLine()
         * 回车 换行: \r\n
         */

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
