package mj_java_01.a17_IO.d_io流.c_字符流.b_练习_逐个字符_逐行打印;

import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;

public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;
    public static void main(String[] args)  {

    }

    /**
     * 01-将文本文件内容 逐个字符打印出来
     *
     */
    @Test
    public void testOneByOneCharPrint() {

        try ( //try-with-resource : 就不用自己去 close()了 流了.
              FileReader reader = new FileReader(new File(ioTestPath + "error_log.json"));
        ) {
            //reader.read();// 读一个字符
            int aChar;
            while ((aChar = reader.read()) != -1) {
                System.out.print((char) aChar);
                sleep(50);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOneByOneLinePrint() {

        try (
            BufferedReader reader = new BufferedReader(new FileReader(ioTestPath + "error_log.json"));
        ) {
            /**
             * 缓冲字符输入流 有很好用的方法:  读一行的功能 自动识别 换行符.
             */
            String line;
            while ((line = reader.readLine()) != null){
                //注意✅: 读出的行已经把 里面的 回车 换行剔出了的. 如果要换行自己换行.
                System.out.println(line);
                sleep(50);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sleep (long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
