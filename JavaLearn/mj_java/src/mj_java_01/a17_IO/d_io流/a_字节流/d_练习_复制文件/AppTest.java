package mj_java_01.a17_IO.d_io流.a_字节流.d_练习_复制文件;

import java.io.File;

public class AppTest {
    private static final String ioTestPath = "/Users/whj/Desktop/io_test/";

    public static void main(String[] args) {
        Files.copy(new File(ioTestPath + "IMG_2129.HEIC"),new File(ioTestPath + "/a/b/c/IMG_2129.HEIC"));
    }
}
