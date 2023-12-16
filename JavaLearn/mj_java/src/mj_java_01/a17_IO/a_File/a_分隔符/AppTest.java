package mj_java_01.a17_IO.a_File.a_分隔符;

import java.io.File;
import java.lang.reflect.Field;

public class AppTest {
    public static void main(String[] args) {
        /**
         * / 正斜杠
         * \ java 中一个反斜杠 是转义字符,如果要表达 \ 要用 \\
         */
        //File file = new File("F:\Files/1.txt"); //反斜杠 java中会报错.
        File file = new File("F:/Files/1.txt");

        /**
         * 名字分隔符: File.separator
         * 在Unix  Linux Mac 中是 正斜杠 /
         * windows : 反斜杠 \
         */
        String separator = File.separator;
        System.out.println(separator);

        /**
         * 路径分隔符: File.pathSeparator
         *
         *
         */
        System.out.println( File.pathSeparator);

    }
}
