package DesignPattern.a_single_responsibility.positive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * 先做出来 原则:
 * 统计一个文件中有多少个单词.
 * 字节流 和 字符流 :  字节流不查 码表, 字符流 要查码表.
 */
public class AppTest {
    public static void main(String[] args) throws Exception {
        //统计一个文件中有多少个单词. 字符流要查码表.
        Reader in = new FileReader("./1.txt");


    }
}
