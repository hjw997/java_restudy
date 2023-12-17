package mj_java_01.a17_IO.d_io流.a_字节流.b_练习_内存中的数据写入文件;

import java.io.File;

public class AppTest {
    private static final String ioTestPath = "/Users/whj/Desktop/io_test/";
    public static void main(String[] args) {

        Files.write("MJ小马哥abc".getBytes(), new File(ioTestPath + "/a/b/c/2.txt"));

    }
}
