package mj_java_01.a17_IO.d_io流.g_数据流_支持基本类型和字符串IO操作;

import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;

public class AppTest {
    private static final String  ioTestPath = PathConstant.ioTestRootPath;
    public static void main(String[] args) throws IOException  {
        /**
         *  用途: 基本数据的归档 和 解档
         *       把基础的 基本类型 等写入. 也可以方便的读去出来.
         *       如下的测试案例 test01 和 test02 分别是使用方法.
         */

    }

    /**
     * 1. 写入基本数据和字符串到文件
     * 用途:基本数据的归档 和 解档
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {

        int age = 20;
        int money = 3000;
        double height = 1.75;
        String name = "Jack";
        File dosFile = new File(ioTestPath + "data.txt");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(dosFile));
        //写入基本数据到文件
        dos.writeInt(age);
        dos.writeInt(money);
        dos.writeDouble(height);
        dos.writeUTF(name);
        dos.close();
    }

    /**
     * 2.从文件中读 数据流.
     */
    @Test
    public void test02() throws IOException {
        File dosFile = new File(ioTestPath + "data.txt");
        DataInputStream dis = new DataInputStream(new FileInputStream(dosFile));

        //读数据 要 按照写入的顺序类型读
        //System.out.println(dis.readDouble()); //不按顺序读. ❌
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());
        dis.close();
        /**
         20
         3000
         1.75
         Jack

         不按顺序读:就是错乱的.
         4.24399173015E-313
         1073479680
         0
         Jack
         */
    }
}














