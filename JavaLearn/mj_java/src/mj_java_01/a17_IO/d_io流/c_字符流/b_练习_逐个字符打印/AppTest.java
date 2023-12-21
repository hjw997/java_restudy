package mj_java_01.a17_IO.d_io流.c_字符流.b_练习_逐个字符打印;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppTest {
    private static final String ioTestPath = "/Users/amos/Desktop/io_test/";
    public static void main(String[] args) throws InterruptedException {
        /**
         * 将文本文件内容 逐个字符打印出来
         *
         */
        try ( //try-with-resource : 就不用自己去 close()了 流了.
             FileReader reader = new FileReader(new File(ioTestPath + "error_log.json"));
        ) {
            //reader.read();// 读一个字符
            int aC;
            while ((aC = reader.read()) != -1) {
                System.out.print((char) aC);
                Thread.sleep(50);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
