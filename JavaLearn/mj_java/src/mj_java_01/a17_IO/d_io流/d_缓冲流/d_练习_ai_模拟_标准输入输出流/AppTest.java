package mj_java_01.a17_IO.d_io流.d_缓冲流.d_练习_ai_模拟_标准输入输出流;

import java.io.*;

public class AppTest {
    public static void main(String[] args) throws IOException {

        /**
         * 如何从控制台 读取用户输入??
         * 读取控制台的输入,相当于 就是读取键盘的输入
         * 像这种 控制台输入,键盘输入 在编程中 叫做 标准输入( 如C++ 的 std cout 等)
         * 标准输入(standard input Stream)流 : 控制台的输入,键盘的输入.
         * 标准输出(standard output Stream)流 : 控制台的输出, 屏幕的输出
         */

        /**
         * java中的标准输入输出是啥?
         * System.out 标准输出流:  public class PrintStream extends FilterOutputStream
         *
         */
        PrintStream printStream = System.out;
        InputStream inputStream = System.in; //字节流.
        //字节流转为 字符, 要编码里面默认是 Charset.default() 默认编码.
        //默认编码和main方法所在文件的编码.
        InputStreamReader isr = new InputStreamReader(System.in);
        /**

         * 字符流
         * 缓冲流
         */
        testAi();

    }

    public  static void testAi() throws IOException {
        /**
         * 读标准输入流
         * 替换句子,
         * 标准输出流 写出
         */
        InputStreamReader in = new InputStreamReader(System.in); //默认编码 utf-8
        BufferedReader reader = new BufferedReader(in);
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replace("吗", "");
            line = line.replace("?", "!!");
            line = line.replace("你", "朕");
            // 让回复的内容缩进一点.
            System.out.println("\t" + line);

        }
    }
}
